package com.huazhu.application.cms.common.zxing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtil {
	
	public static void get(int width,int height,String format, String content, HttpServletResponse response) throws Exception {
		
		ServletOutputStream out = response.getOutputStream();
		Map<EncodeHintType,Object> config = new HashMap<>();
		config.put(EncodeHintType.CHARACTER_SET,"UTF-8");
		config.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		config.put(EncodeHintType.MARGIN, 0);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,config);
		MatrixToImageWriter.writeToStream(bitMatrix,format,out);
		System.out.println("二维码生成完毕，已经输出到页面中。");
	}

}
