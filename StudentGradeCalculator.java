import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame implements ActionListener {
    private JTextField[] subjectFields;
    private JLabel[] subjectLabels;
    private JButton calculateButton;
    private JLabel totalMarksLabel;
    private JLabel averageMarksLabel;
    private JLabel percentageLabel;
    private JLabel gradeLabel;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        subjectFields = new JTextField[6];
        subjectLabels = new JLabel[6];

        for (int i = 0; i < 6; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + ": ");
            add(subjectLabels[i]);
            subjectFields[i] = new JTextField();
            add(subjectFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        totalMarksLabel = new JLabel("Total Marks: ");
        add(totalMarksLabel);

        averageMarksLabel = new JLabel("Average Marks: ");
        add(averageMarksLabel);

        percentageLabel = new JLabel("Percentage: ");
        add(percentageLabel);

        gradeLabel = new JLabel("Grade: ");
        add(gradeLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float totalMarks = 0;
        for (int i = 0; i < 6; i++) {
            totalMarks += Float.parseFloat(subjectFields[i].getText());
        }

        float averageMarks = totalMarks / 6;
        float percentage = (totalMarks / 600) * 100;

        totalMarksLabel.setText("Total Marks: " + totalMarks + " Out of 600");
        averageMarksLabel.setText("Average Marks: " + averageMarks);
        percentageLabel.setText("Percentage: " + percentage);

        char grade = calculateGrade(percentage);
        gradeLabel.setText("Grade: " + grade);
    }

    private char calculateGrade(float percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else if (percentage >= 40) {
            return 'E';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}
