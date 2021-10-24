//package com.couponsystem.clr;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//import org.apache.http.entity.ContentType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.couponsystem.beans.Coupon;
//import com.couponsystem.beans.LoginForm;
//import com.couponsystem.enums.ClientType;
//import com.couponsystem.enums.CouponCategory;
//import com.couponsystem.rest.CompanyController;
//import com.couponsystem.security.LoginController;
//import com.couponsystem.service.LoginService;
//import com.couponsystem.utils.ClrUtils;
//import com.couponsystem.utils.DateUtil;
//
////@Component
////@Order(3)
//public class CompanyClr2 implements CommandLineRunner {
//
//	private final LoginController loginController;
//	private LoginService loginService;
//	private final CompanyController companyController;
//
//	@Autowired
//	public CompanyClr2(LoginController loginController, LoginService loginService,
//			CompanyController companyController) {
//		super();
//		this.loginController = loginController;
//		this.loginService = loginService;
//		this.companyController = companyController;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
////    _  
////  _( )_
//// (_ o _)
////	(_,_)
////		 ___                                           ______          _     _____         _       
////     /  __ \                                         | ___ \        | |   |_   _|       | |      
////	   | /  \/ ___  _ __ ___  _ __   __ _ _ __  _   _  | |_/ /___  ___| |_    | | ___  ___| |_ ___ 
////	   | |    / _ \| '_ ` _ \| '_ \ / _` | '_ \| | | | |    // _ \/ __| __|   | |/ _ \/ __| __/ __|
////	   | \__/\ (_) | | | | | | |_) | (_| | | | | |_| | | |\ \  __/\__ \ |_    | |  __/\__ \ |_\__ \
////	    \____/\___/|_| |_| |_| .__/ \__,_|_| |_|\__, | \_| \_\___||___/\__|   \_/\___||___/\__|___/
////                           | |                 __/ |                                             
////	                         |_|                |___/                                              
//		ClrUtils.companyRestTests();
//
////		------------------------------------------------------------------------------------------------------------
//
//		ClrUtils.testSeparatedLine(" --------->>>>>>>> Testing Company Login:");
//
//		System.out.println("Going to test GOOD company login:");
//		LoginForm goodLoginForm = new LoginForm("KSP@company.com", "KSPP", ClientType.COMPANY);
//		System.out.println(loginController.login(goodLoginForm));
//		String token = loginService.getTokenForClr();
//
////		------------------------------------------------------------------------------------------------------------
//
//		ClrUtils.testSeparatedLine(
//				" --------->>>>>>>> Going to add 5 coupons using companyController.addCompanyCoupon:");
//
//		Coupon coup1 = new Coupon();
//		coup1.setCategory(CouponCategory.ELECTRICITY);
//		coup1.setTitle("iPhone 12 Pro");
//		coup1.setDescription("Apple iPhone 12 Pro Max 128GB, blue color, official importer warranty, no charger.");
//		coup1.setStartDate(DateUtil.dateFormat(2029, 06, 28));
//		coup1.setEndDate(DateUtil.dateFormat(2029, 10, 28));
//		coup1.setAmount(100);
//		coup1.setPrice(100);
//
//		File file1 = new File(
//				"C:\\Users\\hllyl\\git\\CouponSystem_SpringProject_JwtTechnique\\CouponSystem_SpringProject_JwtTechnique\\src\\main\\resources\\static\\pics\\Companies\\KSP\\iPhone12Pro.jpg");
//		FileInputStream inputStream1 = new FileInputStream(file1);
//		MultipartFile multipartFile1 = new MockMultipartFile(file1.getName(), file1.getName(),
//				ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream1);
//
//		Coupon coup2 = new Coupon();
//		coup2.setCategory(CouponCategory.ELECTRICITY);
//		coup2.setTitle("Apple Watch");
//		coup2.setDescription("Apple Watch Series Smart Watch, 6 GPS 40mm, space Gray Aluminum color.");
//		coup2.setStartDate(DateUtil.dateFormat(2029, 07, 28));
//		coup2.setEndDate(DateUtil.dateFormat(2029, 10, 28));
//		coup2.setAmount(200);
//		coup2.setPrice(200);
//
//		File file2 = new File(
//				"C:\\Users\\hllyl\\git\\CouponSystem_SpringProject_JwtTechnique\\CouponSystem_SpringProject_JwtTechnique\\src\\main\\resources\\static\\pics\\Companies\\KSP\\AppleWatch.jpg");
//		FileInputStream inputStream2 = new FileInputStream(file2);
//		MultipartFile multipartFile2 = new MockMultipartFile(file2.getName(), file2.getName(),
//				ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream2);
//
//		Coupon coup3 = new Coupon();
//		coup3.setCategory(CouponCategory.ELECTRICITY);
//		coup3.setTitle("Asus Computer");
//		coup3.setDescription(
//				"Pre-made desktop brand computer from Asus, AMD Ryzen processor holder 39 9 3900X 3.8GHz - 4.6GHz, 64GB memory, 1TB SSD drive.");
//		coup3.setStartDate(DateUtil.dateFormat(2029, 06, 28));
//		coup3.setEndDate(DateUtil.dateFormat(2029, 10, 28));
//		coup3.setAmount(300);
//		coup3.setPrice(300);
//
//		File file3 = new File(
//				"C:\\Users\\hllyl\\git\\CouponSystem_SpringProject_JwtTechnique\\CouponSystem_SpringProject_JwtTechnique\\src\\main\\resources\\static\\pics\\Companies\\KSP\\AsusComputer.jpg");
//		FileInputStream inputStream3 = new FileInputStream(file3);
//		MultipartFile multipartFile3 = new MockMultipartFile(file3.getName(), file3.getName(),
//				ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream3);
//
//		Coupon coup4 = new Coupon();
//		coup4.setCategory(CouponCategory.ELECTRICITY);
//		coup4.setTitle("Apple Screen");
//		coup4.setDescription("Apple Pro Computer Screen XDR Nano Texture Glass 32 '' 6K IPS Retina.");
//		coup4.setStartDate(DateUtil.dateFormat(2029, 07, 28));
//		coup4.setEndDate(DateUtil.dateFormat(2029, 10, 28));
//		coup4.setAmount(400);
//		coup4.setPrice(400);
//
//		File file4 = new File(
//				"C:\\Users\\hllyl\\git\\CouponSystem_SpringProject_JwtTechnique\\CouponSystem_SpringProject_JwtTechnique\\src\\main\\resources\\static\\pics\\Companies\\KSP\\AppleScreen.jpg");
//		FileInputStream inputStream4 = new FileInputStream(file4);
//		MultipartFile multipartFile4 = new MockMultipartFile(file4.getName(), file4.getName(),
//				ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream4);
//
//		System.out.println(companyController.addCompanyCoupon(coup1, multipartFile1, token));
//		System.out.println(companyController.addCompanyCoupon(coup2, multipartFile2, token));
//		System.out.println(companyController.addCompanyCoupon(coup3, multipartFile3, token));
//		System.out.println(companyController.addCompanyCoupon(coup4, multipartFile4, token));
//
//		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.getCompanyDetails:");
//
//		System.out.println(companyController.getCompanyDetails(token));
//	}
//}
