package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import static Utilities.CommonFeatures.*;

public class CheckoutPage extends MainPage{

    @FindBy(id="billing-address-select") WebElement cbAddressList;
    @FindBy(id = "billing:firstname") WebElement txtFirstName;
    @FindBy(id = "billing:middlename") WebElement txtMiddleName;
    @FindBy(id = "billing:lastname") WebElement txtLastName;
    @FindBy(id = "billing:company") WebElement txtCompany;
    @FindBy(id = "billing:street1") WebElement txtAddress;
    @FindBy(id = "billing:street2") WebElement txtStreetAddress;
    @FindBy(id="billing:city") WebElement txtCity;
    @FindBy(id="billing:region_id") WebElement cbStateOrProvince;
    @FindBy(id="billing:postcode") WebElement txtZip;
    @FindBy(id="billing:country_id") WebElement cbCountry;
    @FindBy(id="billing:telephone") WebElement txtTelephone;
    @FindBy(id="billing:fax") WebElement txtFax;
    @FindBy(id="billing:use_for_shipping_yes") WebElement chkShipToThisAddress;
    @FindBy(id="billing:use_for_shipping_no") WebElement chkShipToDifferAddress;
    @FindBy(xpath="//div[@id='checkout-step-billing']//button") WebElement btnContinueAtBillingInfo;
    @FindBy(className = "sp-methods") WebElement textFlatRate;
    @FindBy(xpath = "//div[@id='checkout-step-shipping_method']//button") WebElement btnContinueAtShippingMethod;
    @FindBy(id="p_method_ccsave") WebElement chkCreditCard;
    @FindBy(id="p_method_checkmo") WebElement chkCheckMoneyOrder;
    @FindBy(xpath = "//div[@id='checkout-step-payment']//button") WebElement btnContinueAtPayInfo;
    @FindBy(xpath = "//table[@id='checkout-review-table']") WebElement tblOrderReview;
    @FindBy(xpath = "//table/tfoot/tr[@class='first']//span[@class='price']") WebElement textSubtotal;
    @FindBy(xpath = "//table/tfoot/tr[@class='last']//span[@class='price']") WebElement textGrandTotal;
    @FindBy(xpath = "//table/tfoot/tr[2]//span[@class='price']") WebElement textFeeShipping;
    @FindBy(xpath = "//button[@title='Place Order']") WebElement btnPlaceOrder;
    @FindBy(xpath = "//p[text()='Your order # is: ']/a") WebElement textOrderNubmer;




    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectNewAddress(){
        if(cbAddressList.isDisplayed()){
            selectByText(cbAddressList,"New Address");
        }
        else return;

    }

    public void fillFirstName(String fisrtName){
        fill(txtFirstName,fisrtName);
    }
    public void fillMiddleName(String middleName){
        fill(txtMiddleName,middleName);
    }
    public void fillLastName(String lastName){
        fill(txtLastName,lastName);
    }
    public void fillCompany(String company){
        fill(txtCompany,company);
    }
    public void fillAddress(String address){
        fill(txtAddress,address);
    }
    public void fillStreetAddress(String streetAddress){
        fill(txtStreetAddress,streetAddress);
    }
    public void fillCity(String city){
        fill(txtCity,city);
    }
    public void selectProvince(String province){
        selectByText(cbStateOrProvince,province);
    }
    public void fillZip(String zip){
        fill(txtZip,zip);
    }
    public void selectCountry(String country){
        selectByText(cbCountry,country);
    }
    public void fillTelephone(String phoneNumber){
        fill(txtTelephone,phoneNumber);
    }
    public void fillFax(String faxNumber){
        fill(txtFax,faxNumber);
    }
    public void clickOnContinueAtTab(String page){
        switch (page){
            case "BillInfo":
                click(btnContinueAtBillingInfo);
                break;
            case"ShipMethod":
                click(btnContinueAtShippingMethod);
                break;
            case"PaymentInfo":
                click(btnContinueAtPayInfo);
                break;
            default:
                System.out.printf("Not existing");
                break;

        }
    }

    public String getFlatRate(){

        return textFlatRate.getText();
    }

    public void checkMoneyOrder(){
        check(chkCheckMoneyOrder);
    }
    public String getSubtotal(){
        return textSubtotal.getText();
    }
    public String getFeeShipping(){
        return textFeeShipping.getText();
    }
    public String getGrandTotal(){
        return textGrandTotal.getText();
    }
    public void clickOnPlaceOrder(){
        click(btnPlaceOrder);
    }
    public String getYourNumberOrder(){
        return textOrderNubmer.getText();
    }
    public  void switchToNewTab(){
        switchToNewWindows();
    }
}
