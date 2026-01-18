# InsureFlowX Platform

**InsureFlowX** is a modern, microservices-based insurance management platform designed for scalability and flexibility. It features a distributed backend built with **Spring Boot** and a responsive frontend dashboard built with **Next.js**.

## 🚀 Key Features

*   **Policy Management**: Create, view, and manage insurance policies.
*   **Underwriting Automation**: Automated risk assessment workflow with AI-simulated decision making.
*   **Claims Processing**: Submit and track claims in real-time.
*   **Billing & Payments**: Integrated payment lifecycle management.
*   **API Gateway**: Centralized entry point with load balancing and CORS configuration.

## 🛠️ Tech Stack

### Backend (Microservices)
*   **Java 17+** (Spring Boot 3.2)
*   **H2 Database** (In-Memory for local dev)
*   **Spring Cloud Gateway**
*   **Spring Batch**

### Frontend
*   **Next.js 14+** (App Router)
*   **TypeScript**
*   **TailwindCSS** (v4)
*   **Lucide React** (Icons)

## 🏗️ Architecture

The system consists of the following services:

| Service | Port | Description |
| :--- | :--- | :--- |
| **Integration Gateway** | `8080` | Entry point, routes traffic to microservices. |
| **Policy Service** | `8081` | Manages policy lifecycle (Draft, Active, etc.). |
| **Underwriting Service** | `8082` | Evaluates risk and approvals. |
| **Claims Service** | `8083` | Handles claim submissions and status. |
| **Billing Service** | `8084` | Manages premiums and payments. |
| **Batch Service** | `N/A` | Background jobs for reconciliation. |

---

## 🏁 Getting Started

### Prerequisites
*   Node.js 18+
*   JDK 17 or higher
*   Maven 3.6+

### 1. Start the Backend
We have provided a convenient script to start all services on Windows.

1.  Open a terminal in the project root (`e:\InsuranceFlow`).
2.  Run the startup script:
    ```powershell
    .\start-backend.bat
    ```
    *This will spawn separate windows for Gateway, Policy, Underwriting, Claims, and Billing services.*

### 2. Start the Frontend
1.  Open a new terminal.
2.  Navigate to the frontend directory:
    ```powershell
    cd frontend
    ```
3.  Install dependencies (first time only):
    ```powershell
    npm install
    ```
4.  Run the development server:
    ```powershell
    npm run dev
    ```
5.  Open **[http://localhost:3000](http://localhost:3000)** in your browser.

## 🧪 Usage Workflows

### 1. Create a Policy
*   Navigate to **Policies** -> **Create Policy**.
*   Fill in the details. The system generates a policy with `PENDING_APPROVAL` status.

### 2. Underwriting
*   Navigate to **Underwriting**.
*   You will see the new policy in the queue.
*   Click **Assess Risk** to see the system's recommendation.
*   Click **Approve** or **Reject**. The policy status updates instantly.

### 3. Claims
*   Navigate to **Claims**.
*   Select an active policy and file a claim.
*   View the claim history in the list.

## 📝 License
This project is for educational and demonstration purposes.