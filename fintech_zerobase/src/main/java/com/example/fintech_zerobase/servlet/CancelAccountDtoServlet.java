package com.example.fintech_zerobase.servlet;

import com.example.fintech_zerobase.dto.CancelAccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet("/cancelBalanceServlet")
public class CancelAccountDtoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            CancelAccountDto cancelBalanceDto = mapper.readValue(request.getInputStream(), CancelAccountDto.class);
            System.out.println("CancelBalanceServlet.service");

            response.setStatus(SC_OK);
            mapper.writeValue(response.getWriter(), cancelBalanceDto);
        } catch (Exception e){
            response.setStatus((SC_BAD_REQUEST));
            response.getWriter().write("잘못된 접근 입니다.");
            e.printStackTrace();
        }
    }
}