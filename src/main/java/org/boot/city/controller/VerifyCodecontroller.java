package org.boot.city.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.boot.city.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerifyCodecontroller {
	/* ��ȡ��֤��ͼƬ*/
	 
    @RequestMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response,HttpServletRequest request) {

         try {
        	 int width=200;
        	 int height=69;          
        	 BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        	 //���ɶ�Ӧ��ߵĳ�ʼͼƬ

             String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

             //������һ���෽�������ڴ��븴�ÿ��ǣ������˷�װ��

             //������������֤���ַ���������㣬�����ߣ�����ֵΪ��֤���ַ�      
             
             System.out.println(randomText);

             request.getSession().setAttribute("verifyCode", randomText);
             response.setContentType("image/png");//����������Ӧ��������ΪͼƬ������ǰ̨��ʶ��

             OutputStream os = response.getOutputStream(); //��ȡ�ļ������    
             ImageIO.write(verifyImg,"png",os);//���ͼƬ��

             os.flush();

             os.close();//�ر���

             }catch (IOException e) {
                // this.logger.error(e.getMessage());
                 e.printStackTrace();
             }

    }


}
