package com.example.fintech_zerobase.servlet;

import com.example.fintech_zerobase.dto.DeleteAccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteAccountDtoServlet")
public class DeleteAccountDtoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        try{
            DeleteAccountDto deleteAccountDto = mapper.readValue(request.getInputStream(), DeleteAccountDto.class);

            System.out.println("DeleteAccountDtoServlet.service");

            response.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(response.getWriter(), deleteAccountDto);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("잘못된 접근입니다.");
            e.printStackTrace();
        }
    }
}
