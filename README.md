# Android Mobile Automation with Appium

Automated testing framework for Android mobile applications using Appium, Java, and TestNG.

## Technology Stack

- Appium 3.1.1
- Java 11
- TestNG 7.8.0
- Gradle
- Page Object Model

## Test Coverage

**9 Tests - 100% Pass Rate**

- App launch and navigation
- Product browsing and details
- Shopping cart (add, view, remove)
- User login
- Complete checkout flow (shipping, payment, order placement)

## Prerequisites

- Java 11+
- Node.js
- Android Studio with SDK
- Appium Server

## Installation

**Install Appium:**
```bash
npm install -g appium
appium driver install uiautomator2
```

**Set Environment Variable:**
```bash
# Windows
$env:ANDROID_HOME = "C:\Users\YOUR_USERNAME\AppData\Local\Android\Sdk"

# Mac/Linux
export ANDROID_HOME=$HOME/Library/Android/sdk
```

**Clone Repository:**
```bash
git clone https://github.com/Tshepiso-R/android-appium-automation.git
cd android-appium-automation
```

## Running Tests

**1. Start Emulator**  
Launch Android emulator from Android Studio

**2. Install App**
```bash
adb install app/Android-MyDemoAppRN.1.3.0.apk
```

**3. Start Appium**
```bash
appium
```

**4. Run Tests**
```bash
# Windows
.\gradlew.bat clean test

# Mac/Linux
./gradlew clean test
```

## Test Results

View report: `build/reports/tests/test/index.html`

## Test Data

Edit `src/test/resources/testdata.properties` for:
- Login credentials
- Shipping address
- Payment information

## Author

**Promise Raganya**  
Test Automation Engineer
