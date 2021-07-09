package com.couponsystem.clr;

import java.io.File;
import java.io.FileInputStream;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.couponsystem.beans.Coupon;
import com.couponsystem.beans.LoginForm;
import com.couponsystem.enums.ClientType;
import com.couponsystem.enums.CouponCategory;
import com.couponsystem.rest.CompanyController;
import com.couponsystem.security.LoginController;
import com.couponsystem.service.LoginService;
import com.couponsystem.utils.ClrUtils;
import com.couponsystem.utils.DateUtil;

@Component
@Order(2)
public class CompanyClr implements CommandLineRunner {

	private final LoginController loginController;
	private LoginService loginService;
	private final CompanyController companyController;

	@Autowired
	public CompanyClr(LoginController loginController, LoginService loginService, CompanyController companyController) {
		super();
		this.loginController = loginController;
		this.loginService = loginService;
		this.companyController = companyController;
	}

	@Override
	public void run(String... args) throws Exception {

//    _  
//  _( )_
// (_ o _)
//	(_,_)
//		 ___                                           ______          _     _____         _       
//     /  __ \                                         | ___ \        | |   |_   _|       | |      
//	   | /  \/ ___  _ __ ___  _ __   __ _ _ __  _   _  | |_/ /___  ___| |_    | | ___  ___| |_ ___ 
//	   | |    / _ \| '_ ` _ \| '_ \ / _` | '_ \| | | | |    // _ \/ __| __|   | |/ _ \/ __| __/ __|
//	   | \__/\ (_) | | | | | | |_) | (_| | | | | |_| | | |\ \  __/\__ \ |_    | |  __/\__ \ |_\__ \
//	    \____/\___/|_| |_| |_| .__/ \__,_|_| |_|\__, | \_| \_\___||___/\__|   \_/\___||___/\__|___/
//                           | |                 __/ |                                             
//	                         |_|                |___/                                              
		ClrUtils.companyRestTests();

//		------------------------------------------------------------------------------------------------------------

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Testing Company Login:");
//
		System.out.println("Going to test login exception - *WRONG* *Email*:");
		LoginForm badEmailLoginForm = new LoginForm("BADcomp@comp.com", "1111", ClientType.COMPANY);
		System.out.println(loginController.login(badEmailLoginForm));

		System.out.println();
		System.out.println("Going to test login exception - *WRONG* *Password*:");
		LoginForm badPasswordLoginForm = new LoginForm("comp1Email@comp.com", "1010", ClientType.COMPANY);
		System.out.println(loginController.login(badPasswordLoginForm));

		System.out.println();
		System.out.println("Going to test GOOD company login:");
		LoginForm goodLoginForm = new LoginForm("comp1Email@comp.com", "1111", ClientType.COMPANY);
		System.out.println(loginController.login(goodLoginForm));
		String token = loginService.getTokenForClr();

//		TODO -> Logout
//		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test Company Logout:");

//		------------------------------------------------------------------------------------------------------------

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to add 5 coupons using companyController.addCompanyCoupon:");

		Coupon coup1 = new Coupon();
		coup1.setCategory(CouponCategory.FOOD);
		coup1.setTitle("coup1Title");
		coup1.setDescription("This is coupon description bla bla bla");
		coup1.setStartDate(DateUtil.dateFormat(2029, 06, 28));
		coup1.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup1.setAmount(0);
		coup1.setPrice(100);

		Coupon coup2 = new Coupon();
		coup2.setCategory(CouponCategory.FOOD);
		coup2.setTitle("coup2Title");
		coup2.setDescription("This is coupon description bla bla bla");
		coup2.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup2.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup2.setAmount(200);
		coup2.setPrice(200);

		Coupon coup3 = new Coupon();
		coup3.setCategory(CouponCategory.RESTAURANT);
		coup3.setTitle("coup3Title");
		coup3.setDescription("This is coupon description bla bla bla");
		coup3.setStartDate(DateUtil.dateFormat(2029, 06, 28));
		coup3.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup3.setAmount(888);
		coup3.setPrice(300);

		Coupon coup4 = new Coupon();
		coup4.setCategory(CouponCategory.RESTAURANT);
		coup4.setTitle("coup4Title");
		coup4.setDescription("This is coupon description bla bla bla");
		coup4.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup4.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup4.setAmount(400);
		coup4.setPrice(400);

		Coupon coup5 = new Coupon();
		coup5.setCategory(CouponCategory.RESTAURANT);
		coup5.setTitle("coup5Title");
		coup5.setDescription("This is coupon description bla bla bla");
		coup5.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup5.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup5.setAmount(500);
		coup5.setPrice(500);

		Coupon coup6 = new Coupon();
		coup6.setCategory(CouponCategory.VACATION);
		coup6.setTitle("coup6Title");
		coup6.setDescription("This is coupon description bla bla bla");
		coup6.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup6.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup6.setAmount(600);
		coup6.setPrice(600);

		Coupon coup7 = new Coupon();
		coup7.setCategory(CouponCategory.VACATION);
		coup7.setTitle("coup7Title");
		coup7.setDescription("This is coupon description bla bla bla");
//		coup7.setStartDate(DateUtil.dateFormat(2019, 07, 28));
//		coup7.setEndDate(DateUtil.dateFormat(2019, 8, 28));
		coup7.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup7.setEndDate(DateUtil.dateFormat(2029, 8, 28));
		coup7.setAmount(700);
		coup7.setPrice(700);

		Coupon coup8 = new Coupon();
		coup8.setCategory(CouponCategory.RESTAURANT);
		coup8.setTitle("coup8Title");
		coup8.setDescription("This is coupon description bla bla bla");
		coup8.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup8.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup8.setAmount(800);
		coup8.setPrice(800);

		File file = new File(
				"C:\\Users\\hllyl\\git\\CouponSystem_SpringProject_JwtTechnique\\CouponSystem_SpringProject_JwtTechnique\\src\\main\\resources\\static\\pics\\Happy.jpg");
		FileInputStream inputStream = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
				ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);

		System.out.println(companyController.addCompanyCoupon(coup1, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup2, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup3, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup4, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup5, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup6, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup7, multipartFile, token));
		System.out.println(companyController.addCompanyCoupon(coup8, multipartFile, token));

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to test *BAD REQUEST* for companyController.addCompanyCoupon: (company title coup7Title, already exists)");

		Coupon coup77 = new Coupon();
		coup77.setCategory(CouponCategory.VACATION);
		coup77.setTitle("coup7Title");
		coup77.setDescription("This is coupon description bla bla bla");
		coup77.setStartDate(DateUtil.dateFormat(2029, 07, 28));
		coup77.setEndDate(DateUtil.dateFormat(2029, 10, 28));
		coup77.setAmount(7700);
		coup77.setPrice(7700);

		System.out.println(companyController.addCompanyCoupon(coup77, null, token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.updateCoupon:");

		coup3.setTitle("coup3Title");
		coup3.setDescription("This is coupon description bla bla bla");
		coup3.setStartDate(DateUtil.dateFormat(2029, 06, 29));
		coup3.setEndDate(DateUtil.dateFormat(2029, 10, 29));
		coup3.setAmount(333);
		coup3.setPrice(300);

		System.out.println(companyController.updateCompanyCoupon(coup3, multipartFile, token));

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to test *BAD REQUEST* for companyController.updateCoupon: (update couponId not allowed)");

		coup3.setId(1);
		System.out.println(companyController.updateCompanyCoupon(coup3, multipartFile, token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.deleteCompanyCoupon:");

		System.out.println(companyController.deleteCompanyCoupon(5, token));

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to test *BAD REQUEST* for companyController.deleteCompanyCoupon: (coupon not exist)");

		System.out.println(companyController.deleteCompanyCoupon(11, token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.getAllCompaniesCoupons:");

		System.out.println(companyController.getAllCompaniesCoupons(token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.getAllCouponsByCategory:");

		System.out.println(companyController.getAllCouponsByCategory(CouponCategory.RESTAURANT, token));

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to test *BAD REQUEST* for companyController.getAllCouponsByCategory: (company coupons from category type not found)");

		System.out.println(companyController.getAllCouponsByCategory(CouponCategory.ELECTRICITY, token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.getAllCouponsUnderMaxPrice:");

		System.out.println(companyController.getAllCouponsUnderMaxPrice(300, token));

		ClrUtils.testSeparatedLine(
				" --------->>>>>>>> Going to test *BAD REQUEST* forcompanyController.getAllCouponsUnderMaxPrice: (company coupons under max price not found)");

		System.out.println(companyController.getAllCouponsUnderMaxPrice(22, token));

		ClrUtils.testSeparatedLine(" --------->>>>>>>> Going to test companyController.getCompanyDetails:");

		System.out.println(companyController.getCompanyDetails(token));
	}

}