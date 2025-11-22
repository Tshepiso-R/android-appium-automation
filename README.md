# Android Mobile Automation with Appium

Automated testing framework for Android mobile applications using Appium, Java, and TestNG.

## Technology Stack

- Appium 3.1.1
- Java 11
- TestNG 7.8.0
- Gradle
- Page Object Model

## Prerequisites

- Java 11 or higher
- Node.js
- Android Studio (with Android SDK)
- Appium Server

## Installation

### 1. Install Dependencies

**Android Studio:**  
Download from https://developer.android.com/studio

**Node.js & Appium:**
```bash
npm install -g appium
appium driver install uiautomator2
```

### 2. Set Environment Variable

**Windows:**
```powershell
$env:ANDROID_HOME = "C:\Users\YOUR_USERNAME\AppData\Local\Android\Sdk"
```

**Mac/Linux:**
```bash
export ANDROID_HOME=$HOME/Library/Android/sdk
```

### 3. Clone Repository
```bash
git clone https://github.com/Tshepiso-R/android-appium-automation.git
cd android-appium-automation
```

## Running Tests

### Step 1: Start Emulator
Open Android Studio ? Device Manager ? Launch emulator

### Step 2: Install Test App
```bash
adb install app/Android-MyDemoAppRN.1.3.0.apk
```

### Step 3: Start Appium
```bash
appium
```

### Step 4: Run Tests

**Windows:**
```bash
.\gradlew.bat test
```

**Mac/Linux:**
```bash
./gradlew test
```

## Test Results

View report at: `build/reports/tests/test/index.html`

## Test Coverage

- testAppLaunch - Verify app launches successfully
- testProductsPageTitle - Validate Products page title
- testClickProduct - Test product interaction

## Author

**Promise Raganya**  
Test Automation Engineer
