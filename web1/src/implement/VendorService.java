package implement;

import java.util.List;

import com.test.dto.Goods;
import com.test.dto.Vendor;

public interface VendorService {
	public List<Vendor> selectVendorList(Vendor pVendor); //public써도되고안써도되고 같음
	Vendor selectVendor(Vendor pVendor);
	Goods selectGoods(Goods pGoods);
	int insertVendor(Vendor pVendor); 
	int deleteVendor(Vendor pVendor);
	int updateVendor(Vendor pVendor);
	int getTotalCount(Goods pGoods);
	int writeNumber();
}
