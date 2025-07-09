# 💊 PharmaLens — AI-powered Prescription Analyzer & Interaction Checker

PharmaLens is a full-stack healthcare application that helps clinicians and patients quickly parse prescriptions, generate clear medication instructions, and flag possible drug interactions using lightweight AI/NLP techniques.

---

## 🚀 Features
- ✅ AI-driven parsing of free-text prescriptions
- ✅ Highlights possible drug interactions (e.g., Warfarin + Ibuprofen bleeding risk)
- ✅ Summarizes clear patient instructions
- ✅ Stores a secure history of past prescriptions & analysis
- ✅ Download prescriptions as CSV reports
- ✅ Fully responsive UI, works on mobile and desktop
- ✅ Toast notifications for success & error feedback

---

## ⚙️ Tech Stack
| Layer         | Technology                     |
|---------------|--------------------------------|
| 🐬 Database   | MySQL                          |
| ☕ Backend    | Spring Boot (Java) + JPA       |
| 🐍 AI/NLP     | Python Flask microservice      |
| ⚛️ Frontend   | Next.js (React)                |

---

## 🚀 Getting Started

### 📦 Clone the repository
```bash
git clone https://github.com/yourusername/pharmalens.git
cd pharmalens
```

---

### ⚙️ 1. Set up MySQL
Create a database:
```sql
CREATE DATABASE pharmalens;
```
Ensure your Spring Boot `application.properties` points to:
```
spring.datasource.url=jdbc:mysql://localhost:3306/pharmalens
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

### 🐍 2. Run Python Flask microservice
```bash
cd pharmalens-ai
python -m venv venv
source venv/bin/activate  # on Windows: venv\Scripts\activate
pip install flask
python app.py
```
Runs on: **http://localhost:5000**

---

### ☕ 3. Run Spring Boot backend
```bash
cd pharmalens-backend
mvn spring-boot:run
```
Runs on: **http://localhost:8080**

---

### ⚛️ 4. Run Next.js frontend
```bash
cd pharmalens-ui
npm install
npm run dev
```
Runs on: **http://localhost:3000**

---

## 📝 Example Inputs
Try pasting these into your dashboard textarea:

```
Take Amoxicillin 500mg twice daily after food. Ibuprofen as needed for pain. Also take Aspirin 81mg daily.
```

or

```
Patient is advised to take Ibuprofen 400mg every 6 hours if pain persists, along with Aspirin 81mg daily for heart protection.
```

Watch it generate summaries & flag interactions like:
```
Ibuprofen + Aspirin may increase bleeding risk.
```

---

## 🚀 Future Enhancements
- 🌐 Integrate with real medical knowledge bases (DrugBank / UMLS)
- 🤖 Switch from rule-based to ML models for smarter NLP
- 🔐 Add user authentication for multi-doctor, multi-patient support
- 📊 Build charts to analyze common drug combinations and risks

---

## 🙌 Contributing
Pull requests and ideas are welcome! Please open an issue or submit a PR.

---

## 🚀 Author
Developed by **Prajwal Mrithyunjay Hulamani**.

---

### 🎯 Happy analyzing with **PharmaLens**!
