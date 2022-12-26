package pagerunner;

public interface Selectors {
    String usernameField = "[data-test='username']";
    String passwordField = "[data-test=\"password\"]";
    String loginButton = "[data-test=\"login-button\"]";
    String password = "secret_sauce";
    String productHeader =".title";
    String similarImages = "a>.inventory_item_img";
    String imageSource = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";
    String errorBanner = "[data-test=\"error\"]";
    String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
    String productTitle = "PRODUCTS";
}
