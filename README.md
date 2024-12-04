
# Zidio School Manager

Zidio School Manager is a Java-based application designed to manage school operations, including student registration, updates, and report generation. The application uses Swing for the user interface and Maven for project management.

## Features

- **Student Registration**: Add new students to the system.
- **Update Student Information**: Modify existing student details.
- **View Student List**: Display a list of all registered students.
- **Generate Reports**: Create PDF reports for class lists, school registers, and application reports.

## Screenshots
![Main UI Screenshot](src/main/resources/App_screenshots/Screenshot%20from%202024-12-04%2013-57-25.png)
![Main UI Screenshot](src/main/resources/App_screenshots/Screenshot%20from%202024-12-04%2013-55-21.png)
![Main UI Screenshot](src/main/resources/App_screenshots/Screenshot%20from%202024-12-04%2013-55-26.png)

## Technologies Used

- **Java**: Core programming language.
- **Swing**: For building the graphical user interface.
- **Maven**: For project management and dependency handling.
- **SQL**: For database operations.

## Project Structure

- `src/main/java/org/zidioschool/userInterface/`: Contains the main UI components.
  - `MainUI.java`: The main frame of the application.
  - `AboutPanel.java`: Panel for generating reports.
  - `customComponents/`: Custom UI components like `GradientPanel.java`.
- `src/main/resources/`: Resources such as images and configuration files.
- `src/test/java/`: Unit tests for the application.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/zidio-school-manager.git
   cd zidio-school-manager
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn exec:java -Dexec.mainClass="org.zidioschool.userInterface.MainUI"
   ```

## Usage

- **Login**: Start the application and log in using your credentials.
- **Navigation**: Use the buttons at the top to navigate between different panels (Registration, Update, View List, Downloads).
- **Generate Reports**: Go to the Downloads panel to generate various PDF reports.

## Custom Components

- **GradientPanel**: A custom JPanel with a gradient background.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any inquiries or issues, please contact _gunnahleonagandi@gmaic.com_.

```
