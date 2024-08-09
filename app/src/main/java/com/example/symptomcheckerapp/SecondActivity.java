package com.example.symptomcheckerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // For any queries contact : prathamdt@gmail.com
        // Written by Pratham Darshankumar Thakkar

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        String symp1 = getIntent().getStringExtra("first");
        System.out.println(symp1);
        String symp2 = getIntent().getStringExtra("second");
        System.out.println(symp2);
        String symp3 = getIntent().getStringExtra("third");
        System.out.println(symp3);

        TextView header = findViewById(R.id.textView3);
        TextView desc = findViewById(R.id.textView2);
        Button share_button = findViewById(R.id.button);

        String pd = predictDisease(symp1, symp2, symp3);

        System.out.println(pd);

        String pd_desc = getDiseaseDescription(pd);

        header.setText(pd);
        desc.setText(pd_desc);

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");

                i.putExtra(Intent.EXTRA_SUBJECT, pd);
                //i.putExtra(Intent.EXTRA_TEXT, "Symptoms : " + symp1 + " " + symp2 + " " + symp3);
                i.putExtra(Intent.EXTRA_TEXT, "Disease : " + pd + " --> Description : " + pd_desc +
                        "  Via the new symptom checker by VITB");

                startActivity(Intent.createChooser(i, "choose a platform"));
            }
        });

    }


    public String predictDisease(String s1, String s2, String s3) {
        // Define the list of possible symptoms
        List<String> symptoms = Arrays.asList(
                s1, s2, s3
        );

        // Initialize counts for each disease
        int commonColdCount = 0;
        int influenzaCount = 0;
        int diabetesCount = 0;
        int tuberculosisCount = 0;
        int asthmaCount = 0;
        int sinusitisCount = 0;
        int pneumoniaCount = 0;
        int gastroenteritisCount = 0;
        int bronchitisCount = 0;
        int foodPoisoningCount = 0;

        // Increase counts based on symptoms
        for (String symptom : symptoms) {
            switch (symptom) {
                case "Fever":
                    influenzaCount++;
                    pneumoniaCount++;
                    tuberculosisCount++;
                    break;
                case "Cough":
                    commonColdCount++;
                    influenzaCount++;
                    pneumoniaCount++;
                    tuberculosisCount++;
                    bronchitisCount++;
                    asthmaCount++;
                    break;
                case "Headache":
                    influenzaCount++;
                    sinusitisCount++;
                    break;
                case "Fatigue":
                    influenzaCount++;
                    diabetesCount++;
                    pneumoniaCount++;
                    tuberculosisCount++;
                    asthmaCount++;
                    break;
                case "Sore Throat":
                    influenzaCount++;
                    sinusitisCount++;
                    bronchitisCount++;
                    break;
                case "Runny Nose":
                    commonColdCount++;
                    sinusitisCount++;
                    break;
                case "Muscle Pain":
                    influenzaCount++;
                    pneumoniaCount++;
                    tuberculosisCount++;
                    break;
                case "Chills":
                    influenzaCount++;
                    pneumoniaCount++;
                    tuberculosisCount++;
                    break;
                case "Shortness of Breath":
                    pneumoniaCount++;
                    tuberculosisCount++;
                    asthmaCount++;
                    bronchitisCount++;
                    break;
                case "Loss of Taste":
                case "Loss of Smell":
                    influenzaCount++;
                    sinusitisCount++;
                    break;
                case "Nausea":
                case "Vomiting":
                    gastroenteritisCount++;
                    foodPoisoningCount++;
                    break;
                case "Diarrhea":
                    gastroenteritisCount++;
                    foodPoisoningCount++;
                    break;
                case "Congestion":
                    sinusitisCount++;
                    foodPoisoningCount++;
                    gastroenteritisCount++;
                    break;
                case "Sneezing":
                    commonColdCount++;
                    sinusitisCount++;
                    break;
                case "Chest Pain":
                    pneumoniaCount++;
                    tuberculosisCount++;
                    bronchitisCount++;
                    asthmaCount++;
                    break;
            }
        }

        // Determine the most likely disease
        int maxCount = 0;
        String predictedDisease = "Unknown";

        if (commonColdCount > maxCount) {
            maxCount = commonColdCount;
            predictedDisease = "Common Cold";
        }
        if (influenzaCount > maxCount) {
            maxCount = influenzaCount;
            predictedDisease = "Influenza";
        }
        if (diabetesCount > maxCount) {
            maxCount = diabetesCount;
            predictedDisease = "Diabetes";
        }
        if (tuberculosisCount > maxCount) {
            maxCount = tuberculosisCount;
            predictedDisease = "Tuberculosis";
        }
        if (asthmaCount > maxCount) {
            maxCount = asthmaCount;
            predictedDisease = "Asthma";
        }
        if (sinusitisCount > maxCount) {
            maxCount = sinusitisCount;
            predictedDisease = "Sinusitis";
        }
        if (pneumoniaCount > maxCount) {
            maxCount = pneumoniaCount;
            predictedDisease = "Pneumonia";
        }
        if (gastroenteritisCount > maxCount) {
            maxCount = gastroenteritisCount;
            predictedDisease = "Gastroenteritis";
        }
        if (bronchitisCount > maxCount) {
            maxCount = bronchitisCount;
            predictedDisease = "Bronchitis";
        }
        if (foodPoisoningCount > maxCount) {
            maxCount = foodPoisoningCount;
            predictedDisease = "Food Poisoning";
        }

        return predictedDisease;
    }
    public static String getDiseaseDescription(String disease) {
        switch (disease) {
            case "Common Cold":
                return "The common cold is a viral infection of the upper respiratory tract. It is caused by various viruses, primarily rhinoviruses. Symptoms include a runny nose, sore throat, cough, sneezing, congestion, and mild fever. The common cold is highly contagious and spreads through airborne droplets or contact with contaminated surfaces. Treatment focuses on relieving symptoms, such as rest, hydration, and over-the-counter medications.";

            case "Influenza":
                return "Influenza, commonly known as the flu, is a contagious respiratory illness caused by influenza viruses. Symptoms include fever, chills, muscle aches, cough, congestion, runny nose, headaches, and fatigue. The flu can lead to serious complications, especially in young children, the elderly, and people with underlying health conditions. Vaccination is the most effective way to prevent influenza and its complications.";

            case "Diabetes":
                return "Diabetes is a chronic condition that affects the body's ability to regulate blood sugar levels. There are two main types: Type 1 diabetes, where the body does not produce insulin, and Type 2 diabetes, where the body becomes resistant to insulin. Symptoms include increased thirst, frequent urination, extreme fatigue, and blurred vision. Management includes lifestyle changes, monitoring blood sugar levels, and medications.";

            case "Tuberculosis":
                return "Tuberculosis (TB) is a bacterial infection caused by Mycobacterium tuberculosis. It primarily affects the lungs but can spread to other parts of the body. Symptoms include a persistent cough, chest pain, weight loss, fever, and night sweats. TB is highly contagious and spreads through airborne droplets. Treatment involves a long course of antibiotics, and prevention includes vaccination and public health measures.";

            case "Asthma":
                return "Asthma is a chronic respiratory condition characterized by inflammation and narrowing of the airways, leading to difficulty breathing. Symptoms include wheezing, shortness of breath, chest tightness, and coughing, especially at night or early in the morning. Asthma triggers include allergens, exercise, cold air, and respiratory infections. Management includes avoiding triggers and using medications such as inhalers.";

            case "Sinusitis":
                return "Sinusitis is inflammation of the sinuses, often caused by infections, allergies, or nasal polyps. Symptoms include facial pain or pressure, nasal congestion, headache, runny nose, and reduced sense of smell. Acute sinusitis is usually caused by a viral infection and resolves on its own, while chronic sinusitis may require medical treatment. Management includes decongestants, nasal sprays, and in some cases, antibiotics.";

            case "Pneumonia":
                return "Pneumonia is an infection that inflames the air sacs in one or both lungs, which may fill with fluid. It can be caused by bacteria, viruses, or fungi. Symptoms include fever, chills, cough with phlegm, chest pain, and difficulty breathing. Pneumonia can range from mild to life-threatening, especially in vulnerable populations. Treatment depends on the cause and may include antibiotics, antiviral medications, and supportive care.";

            case "Gastroenteritis":
                return "Gastroenteritis, also known as stomach flu, is an inflammation of the gastrointestinal tract, typically caused by viral or bacterial infections. Symptoms include diarrhea, vomiting, nausea, stomach cramps, and fever. It is highly contagious and spreads through contaminated food, water, or contact with infected individuals. Treatment focuses on hydration and symptom relief, and severe cases may require medical attention.";

            case "Bronchitis":
                return "Bronchitis is inflammation of the bronchial tubes, which carry air to the lungs. It can be acute or chronic. Acute bronchitis is usually caused by viral infections and presents with a cough, mucus production, fatigue, shortness of breath, and chest discomfort. Chronic bronchitis, often due to smoking, is a long-term condition requiring medical management. Treatment includes rest, fluids, and medications to ease symptoms.";

            case "Food poisoning":
                return "Food poisoning is an illness caused by consuming contaminated food or drinks. Common causes include bacteria (e.g., Salmonella, E. coli), viruses (e.g., norovirus), and parasites. Symptoms typically include nausea, vomiting, diarrhea, stomach cramps, and fever. Most cases resolve without medical treatment, but severe cases may require medical attention. Prevention involves proper food handling, cooking, and hygiene practices.";

            default:
                return "Disease not found. Please provide a valid disease name.";
        }
    }
}


/*

        © Pratham Darshankumar Thakkar

 */