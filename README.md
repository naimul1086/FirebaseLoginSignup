# 📱 Firebase Authentication Android App

A simple and clean Android application demonstrating **Firebase Authentication** using **Email & Password**. This project is built for learning purposes with a focus on **basic authentication flow**, **UI switching**, and **user session handling**.

---

## 🚀 Features

### 🔐 Authentication System

* User **Sign Up (Create Account)**
* User **Login**
* User **Logout**

### 🔄 Smart Navigation Flow

* If user is **not logged in** → Redirect to **Login Page**
* From **Login Page** → Switch to **Sign Up Page**
* From **Sign Up Page** → Switch back to **Login Page**
* If user is **already logged in** → Redirect directly to **Home Page**

---

## 🏠 Home Page

* Displays:

  * ✅ **User ID**
  * ✅ **User Email**
* Includes:

  * 🔓 **Logout Button**

    * On click → User is logged out
    * Redirects back to **Login Page**

---

## 🧠 App Logic Flow

```text
App Start
   ↓
Check User Session
   ↓
IF Logged In → Home Page
ELSE → Login Page

Login Page:
   - Login User
   - Go to Sign Up Page

Sign Up Page:
   - Create New User
   - Go to Login Page

Home Page:
   - Show User Info (UID + Email)
   - Logout → Back to Login Page
```

---

## 🛠️ Tech Stack

* **Language:** Java
* **UI Design:** XML
* **Authentication:** Firebase Authentication
* **UI Components:**

  * Material Button
  * TextInputLayout
  * TextInputEditText

---

## 🎨 UI Overview

* Clean and minimal design using **Material Components**
* Smooth navigation between **Login ↔ Sign Up**
* Simple and readable **Home Screen**

---

## 📂 Project Structure (Basic)

```
- LoginActivity
- SignupActivity
- HomeActivity
- FirebaseAuth Integration
- XML Layout Files
```

---

## ⚙️ Firebase Setup

1. Create project in Firebase Console
2. Enable **Email/Password Authentication**
3. Connect your Android app
4. Add `google-services.json`
5. Sync project

---

## ✅ Purpose of This Project

* Learn **Firebase Authentication**
* Understand **User Session Management**
* Practice **Activity Navigation**
* Build a **basic real-world login system**

---

## 💡 Future Improvements

* Add **Password Reset**
* Add **Email Verification**
* Improve UI/UX with animations
* Store additional user data using Firestore

---

## 📌 Note

This is a **basic beginner-friendly project**. Ideal for those starting Android development with Firebase.

---

## ❤️ Author

Made for learning and practice. Feel free to modify and expand 🚀
