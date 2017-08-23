package com.test.service;

import implement.VendorService;
import implement.VendorServiceImpl;

public class ServiceFactory {
	private static VendorService vendorService = new VendorServiceImpl();
	public static VendorService getVendorService(){
		return vendorService;
	}
}