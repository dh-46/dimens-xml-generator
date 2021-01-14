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
    private JLabel tvLabelScale = new JLabel();
    private JLabel tvLabelFolderName = new JLabel();
    private JLabel tvLabelProjectPath = new JLabel();


    public DimensFrame(String title) throws HeadlessException {
        super(title);
        initView();
    }

    private void initView() {
        setSize(600, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        btnGenerate.setText("Generate");
        add(btnGenerate, BorderLayout.SOUTH);

        GridLayout gridLayout = new GridLayout(3,2);
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

        tfInputScale.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputFolderName.setFont(new Font("Default", Font.PLAIN, 16));
        tfInputProjectPath.setFont(new Font("Default", Font.PLAIN, 16));

        jPanel.add(tvLabelScale);
        jPanel.add(tfInputScale);
        jPanel.add(tvLabelFolderName);
        jPanel.add(tfInputFolderName);
        jPanel.add(tvLabelProjectPath);
        jPanel.add(tfInputProjectPath);

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
        GenerateDimensTool.createDimens(scale, folderName, projectPath);
    }
}
