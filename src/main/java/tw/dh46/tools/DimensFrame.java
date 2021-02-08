package tw.dh46.tools;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DimensFrame extends JFrame {

    private JButton btnGenerate = new JButton();
    private JTextField tfInputScale = new JTextField();
    private JTextField tfInputFolderName = new JTextField();
    private JTextField tfInputProjectPath = new JTextField();
    private JTextField tfInputSpMax = new JTextField();
    private JTextField tfInputSpMin = new JTextField();
    private JTextField tfInputDpMax = new JTextField();
    private JTextField tfInputDpMin = new JTextField();
    private JLabel tvLabelScale = new JLabel();
    private JLabel tvLabelFolderName = new JLabel();
    private JLabel tvLabelProjectPath = new JLabel();
    private JLabel tvLabelInputSpMax = new JLabel();
    private JLabel tvLabelInputSpMin = new JLabel();
    private JLabel tvLabelInputDpMax = new JLabel();
    private JLabel tvLabelInputDpMin = new JLabel();


    public DimensFrame(String title) throws HeadlessException {
        super(title);
        initView();
    }

    private void initView() {
        setSize(600, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        btnGenerate.setText("Generate");
        add(btnGenerate, BorderLayout.SOUTH);

        GridLayout gridLayout = new GridLayout(7,2);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBorder(new EmptyBorder(20,20,20,20));

        tvLabelScale.setText("Scale Ratio");
        tvLabelScale.setFont(new Font("Default", Font.BOLD, 18));
        tvLabelScale.setBorder(new EmptyBorder(10,10,10,10));

        tvLabelFolderName.setText("<html><body>Folder Name<br/>(values-sw600dp)</html>");
        tvLabelFolderName.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelFolderName.setFont(new Font("Default", Font.BOLD, 18));

        tvLabelProjectPath.setText("Project Path");
        tvLabelProjectPath.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelProjectPath.setFont(new Font("Default", Font.BOLD, 18));

        tvLabelInputDpMax.setText("DP Max");
        tvLabelInputDpMax.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelInputDpMax.setFont(new Font("Default", Font.BOLD, 18));

        tvLabelInputDpMin.setText("DP Min");
        tvLabelInputDpMin.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelInputDpMin.setFont(new Font("Default", Font.BOLD, 18));

        tvLabelInputSpMax.setText("SP Max");
        tvLabelInputSpMax.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelInputSpMax.setFont(new Font("Default", Font.BOLD, 18));

        tvLabelInputSpMin.setText("SP Min");
        tvLabelInputSpMin.setBorder(new EmptyBorder(10,10,10,10));
        tvLabelInputSpMin.setFont(new Font("Default", Font.BOLD, 18));

        tfInputScale.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputFolderName.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputProjectPath.setFont(new Font("Default", Font.PLAIN, 16));

        tfInputDpMax.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputDpMin.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputSpMax.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputSpMin.setFont(new Font("Default", Font.PLAIN, 16));

        jPanel.add(tvLabelScale);
        jPanel.add(tfInputScale);
        jPanel.add(tvLabelFolderName);
        jPanel.add(tfInputFolderName);
        jPanel.add(tvLabelProjectPath);
        jPanel.add(tfInputProjectPath);

        jPanel.add(tvLabelInputDpMax);
        jPanel.add(tfInputDpMax);

        jPanel.add(tvLabelInputDpMin);
        jPanel.add(tfInputDpMin);

        jPanel.add(tvLabelInputSpMax);
        jPanel.add(tfInputSpMax);

        jPanel.add(tvLabelInputSpMin);
        jPanel.add(tfInputSpMin);

        add(jPanel);

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doGenerate();
            }
        });

        setVisible(true);
    }

    private void doGenerate() {
        float scale = Float.parseFloat(tfInputScale.getText());
        String projectPath = tfInputProjectPath.getText();
        String folderName = tfInputFolderName.getText();

        int dpMax = Integer.parseInt(tfInputDpMax.getText());
        int dpMin = Integer.parseInt(tfInputDpMin.getText());
        int spMax = Integer.parseInt(tfInputSpMax.getText());
        int spMin = Integer.parseInt(tfInputSpMin.getText());

        GenerateDimensTool.createDimens(scale, folderName, projectPath, dpMax, dpMin, spMax, spMin);
    }
}
