# Symptom Checker App [Android]

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android)
![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk)
![ML](https://img.shields.io/badge/ML-TensorFlow%20Lite-FF6F00?logo=tensorflow)

## Overview

This is a Symptom Checker mobile application built for Android. It allows users to input their symptoms and receive a potential diagnosis based on an integrated machine learning model.

This project was developed as part of the **App Development** course under the guidance of **Dr. Devraj Vishnu**, focusing on the practical implementation of machine learning models in mobile applications.

---

## Key Features

*   **Symptom Input:** A simple and intuitive user interface built with XML for users to enter their current symptoms.
*   **ML-Powered Diagnosis:** Utilizes a pre-trained machine learning model (via TensorFlow Lite) to predict potential medical conditions based on the input.
*   **Condition Information:** Displays details about the predicted condition to provide immediate, high-level information to the user.
*   **Offline:** The core diagnosis functionality works entirely offline, as the model is bundled locally within the app.
*   **Share Symptoms:** Users have the option to share the symptoms and their potential condition or ML based diagnosis in Whattsapp, Messages, and other Social Media platforms

---

## Tech Stack

*   **Platform:** Android
*   **Language:** Java
*   **UI/Layout:** XML (Extensible Markup Language)
*   **Machine Learning:** TensorFlow Lite for on-device model inference.
*   **IDE:** Android Studio

---

## Setup and Installation

To build and run this project locally, you will need Android Studio.

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/symptom-checker-app.git
    ```
2.  **Open in Android Studio:**
    *   Open Android Studio.
    *   Select `File` > `Open` and navigate to the cloned project directory.
3.  **Build the project:**
    *   Let Gradle sync and download the required dependencies.
    *   Click the `Run 'app'` button (or `Shift` + `F10`) to build and run the application on an Android emulator or a physical device.
