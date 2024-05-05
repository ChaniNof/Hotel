
public class BussinesGuest extends Guest {
private String bussinesGuestcod;
private static int discountPercent;

public BussinesGuest(String bussinesGuestcod) {
	this.bussinesGuestcod = bussinesGuestcod;
}

public String getBussinesGuestcod() {
	return bussinesGuestcod;
}

public void setBussinesGuestcod(String bussinesGuestcod) {
	this.bussinesGuestcod = bussinesGuestcod;
}

public static int getDiscountPercent() {
	return discountPercent;
}

public static void setDiscountPercent(int discountPercent) {
	BussinesGuest.discountPercent = discountPercent;
}


}
