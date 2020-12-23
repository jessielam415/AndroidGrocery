# Android Grocery

## Setup 
1. After you clone the directory, open the project with Android Studio. Make sure you have "GroceriesCSC301 copy 2" set as your root directory. Navigate to ~/app/src/java/com.example.groceriescsc301/MainActivity.java

2. You will need an emulator to run the project. Follow the steps on https://docs.expo.io/workflow/android-studio-emulator/ to set up an emulator. Please use virtual device Pixel 3 API 28. (If you want to use another virtual device, please make sure its minimum SDK is above API 23: Android 6.0 (Marshmellow).)

3. Run MainActivity.java. The mobile application will now run on your selected virtual device.

Note: Please use your emulator virtual device like how you would use your smartphone with the cursor as your finger. To ensure you can scroll through the app properly, make sure you click and drag using your cursor instead of simply using your computer mouse or trackpad to scroll. 

## Notable Features and How to Use

1. Adding Items to a cart system 
    - Click on the grocery item you would like to add. This will bring you to a screen where you can select the quantity of that item you want as well as add the item to cart using the "Add To Cart" button. 

2. Opening cart
    - In the Main Activity of the application, there is a shopping cart icon on the top right of the screen. Click on the icon to view your cart. Your cart includes items previously added to cart. Items can be removed by clicking the trash icon next to the particular item you want to remove. The clear all button clears all items in your cart.

3. Price calculation with tax (13% HST) and discount
    - The shopping cart has three price displays, showing the price before tax, price after tax, and the total price with tax and discount

    - Taxes are automatically displayed

4. Ability to apply discounts (Percentage)
    - You can enter a discount percentage between 0 and 100 at the bottom of the cart activity
    - Click apply discount to apply your entered discount amount. The total price with tax and discount will change accordingly
    
    *Note: Discount is calculated before tax


## Testing

Testing of the Project can be implemented with JUnit and Mockito (for Unit and Instrumentation tests) as well as Expresso (for UI tests)
