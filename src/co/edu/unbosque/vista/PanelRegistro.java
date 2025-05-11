package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {

    protected JTextField txtUsuario;
    protected JPasswordField txtContrasena;
    protected JTextField txtCorreo;
    protected JComboBox<String> comboNacionalidad;
    protected JButton btnVolver;
    protected JButton btnRegistrarse;

    protected JPanel campoExtra1;
    protected JPanel campoExtra2;

    public PanelRegistro() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        inicializarComponentes();

        
    }
    public void inicializarComponentes() {
    	
    	// Título
        JLabel lblTitulo = new JLabel("Registro de Persona", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central con 8 filas
        JPanel panelCampos = new JPanel(new GridLayout(8, 1, 10, 10));

        // Fila 1: Usuario
        JPanel panelUsuario = new JPanel(new BorderLayout());
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        panelUsuario.add(lblUsuario, BorderLayout.NORTH);
        panelUsuario.add(txtUsuario, BorderLayout.CENTER);
        panelCampos.add(panelUsuario);

        // Fila 2: Contraseña
        JPanel panelContrasena = new JPanel(new BorderLayout());
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        panelContrasena.add(lblContrasena, BorderLayout.NORTH);
        panelContrasena.add(txtContrasena, BorderLayout.CENTER);
        panelCampos.add(panelContrasena);

        // Fila 3: Correo
        JPanel panelCorreo = new JPanel(new BorderLayout());
        JLabel lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField();
        panelCorreo.add(lblCorreo, BorderLayout.NORTH);
        panelCorreo.add(txtCorreo, BorderLayout.CENTER);
        panelCampos.add(panelCorreo);

        // Fila 4: Nacionalidad (con lista de países directa)
        JPanel panelNacionalidad = new JPanel(new BorderLayout());
        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        String[] paises = {
        	    "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia",
        	    "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin",
        	    "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana",
        	    "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún",
        	    "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras",
        	    "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca",
        	    "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia",
        	    "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia",
        	    "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guinea", "Guinea-Bisáu",
        	    "Guinea Ecuatorial", "Guyana", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán",
        	    "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania",
        	    "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia",
        	    "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí",
        	    "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia",
        	    "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega",
        	    "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay",
        	    "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa",
        	    "República del Congo", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumanía",
        	    "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía",
        	    "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia",
        	    "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia",
        	    "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán",
        	    "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam",
        	    "Yemen", "Yibuti", "Zambia", "Zimbabue"
        	};

        comboNacionalidad = new JComboBox<>(paises);
        comboNacionalidad.setMaximumRowCount(10);
       
        panelNacionalidad.add(lblNacionalidad, BorderLayout.NORTH);
        panelNacionalidad.add(comboNacionalidad, BorderLayout.CENTER);
        panelCampos.add(panelNacionalidad);

        // Fila 5 y 6: campos extra
        campoExtra1 = new JPanel(new BorderLayout());
        campoExtra2 = new JPanel(new BorderLayout());
        panelCampos.add(campoExtra1);
        panelCampos.add(campoExtra2);

        // Fila 7: Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnRegistrarse = new JButton("Registrarse");
        panelBotones.add(btnVolver);
        panelBotones.add(btnRegistrarse);
        panelCampos.add(panelBotones);

        add(panelCampos, BorderLayout.CENTER);
    }

    // Getters
    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JComboBox<String> getComboNacionalidad() {
        return comboNacionalidad;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public JPanel getCampoExtra1() {
        return campoExtra1;
    }

    public JPanel getCampoExtra2() {
        return campoExtra2;
    }
}
