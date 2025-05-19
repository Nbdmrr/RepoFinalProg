package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel base para el registro de usuarios en el sistema.
 * Incluye campos comunes como usuario, contraseña, correo electrónico y nacionalidad.
 * Las clases que hereden de este panel pueden agregar campos específicos para
 * cada tipo de usuario (jugador, entrenador, administrador).
 */
public class PanelRegistro extends JPanel {

    protected JTextField txtUsuario;
    protected JPasswordField txtContrasena;
    protected JTextField txtCorreo;
    protected JComboBox<String> comboNacionalidad;
    protected JButton btnVolver;
    protected JButton btnRegistrarse;

    protected JPanel campoExtra1;
    protected JPanel campoExtra2;
    private JLabel lblTitulo;

    /**
     * Constructor de la clase PanelRegistro.
     * Inicializa el panel con sus componentes y establece el diseño.
     */
    public PanelRegistro() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        inicializarComponentes();

        
    }
    /**
     * Inicializa los componentes del panel, como etiquetas, campos de texto,
     * combo box y botones.
     */
    public void inicializarComponentes() {
        
        
        setLblTitulo(new JLabel("", SwingConstants.CENTER));
        getLblTitulo().setFont(new Font("Arial", Font.BOLD, 22));
        add(getLblTitulo(), BorderLayout.NORTH);

        JPanel panelCampos = new JPanel(new GridLayout(8, 1, 10, 10));

        JPanel panelUsuario = new JPanel(new BorderLayout());
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        panelUsuario.add(lblUsuario, BorderLayout.NORTH);
        panelUsuario.add(txtUsuario, BorderLayout.CENTER);
        panelCampos.add(panelUsuario);

        JPanel panelContrasena = new JPanel(new BorderLayout());
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        panelContrasena.add(lblContrasena, BorderLayout.NORTH);
        panelContrasena.add(txtContrasena, BorderLayout.CENTER);
        panelCampos.add(panelContrasena);

        JPanel panelCorreo = new JPanel(new BorderLayout());
        JLabel lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField();
        panelCorreo.add(lblCorreo, BorderLayout.NORTH);
        panelCorreo.add(txtCorreo, BorderLayout.CENTER);
        panelCampos.add(panelCorreo);

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

        campoExtra1 = new JPanel(new BorderLayout());
        campoExtra2 = new JPanel(new BorderLayout());
        panelCampos.add(campoExtra1);
        panelCampos.add(campoExtra2);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnRegistrarse = new JButton("Registrarse");
        panelBotones.add(btnVolver);
        panelBotones.add(btnRegistrarse);
        panelCampos.add(panelBotones);

        add(panelCampos, BorderLayout.CENTER);
    }
    /**
     * Valida si el correo electrónico ingresado tiene un dominio válido.
     * @param correo Correo electrónico a validar.
     * @return true si el correo es válido, false si no lo es.
     */
    public boolean validarCorreo(String correo) {
       
        String[] dominiosValidos = {"@gmail.com", "@hotmail.com", "@unbosque.edu.co", "@outlook.com"};

        for (String dominio : dominiosValidos) {
            if (correo.endsWith(dominio)) {
                return true;
            }
        }

        JOptionPane.showMessageDialog(this, "El correo debe terminar en @gmail.com, @hotmail.com, @outlook.com o @unbosque.edu.co", "Correo inválido", JOptionPane.WARNING_MESSAGE);
        
        return false;
    }
    /**
     * Devuelve el campo de texto para el nombre de usuario.
     * @return JTextField Campo de texto para el nombre de usuario.
     */
    public JTextField getTxtUsuario() {
        return txtUsuario;
    }
    /**
     * Establece el campo de texto para el nombre de usuario.
     * @param txtUsuario Campo de texto para el nombre de usuario.
     */
    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }
    /**
     * Devuelve el campo de contraseña.
     * @return JPasswordField Campo de contraseña.
     */
    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }
    /**
     * Establece el campo de contraseña.
     * @param txtContrasena Campo de contraseña.
     */
    public void setTxtContrasena(JPasswordField txtContrasena) {
        this.txtContrasena = txtContrasena;
    }
    /**
     * Devuelve el campo de texto para el correo electrónico.
     * @return JTextField Campo de texto para el correo electrónico.
     */
    public JTextField getTxtCorreo() {
        return txtCorreo;
    }
    /**
     * Establece el campo de texto para el correo electrónico.
     * @param txtCorreo Campo de texto para el correo electrónico.
     */
    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }
    /**
     * Devuelve el combo box para la selección de nacionalidad.
     * @return JComboBox<String> Combo box para la selección de nacionalidad.
     */
    public JComboBox<String> getComboNacionalidad() {
        return comboNacionalidad;
    }
    /**
     * Establece el combo box para la selección de nacionalidad.
     * @param comboNacionalidad Combo box para la selección de nacionalidad.
     */
    public void setComboNacionalidad(JComboBox<String> comboNacionalidad) {
        this.comboNacionalidad = comboNacionalidad;
    }
    /**
     * Devuelve el botón para volver.
     * @return JButton Botón para volver.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }
    /**
     * Establece el botón para volver.
     * @param btnVolver Botón para volver.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }
    /**
     * Devuelve el botón para registrarse.
     * @return JButton Botón para registrarse.
     */
    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }
    /**
     * Establece el botón para registrarse.
     * @param btnRegistrarse Botón para registrarse.
     */
    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;
    }
    /**
     * Devuelve el panel para campos extra 1.
     * @return JPanel Panel para campos extra 1.
     */
    public JPanel getCampoExtra1() {
        return campoExtra1;
    }
    /**
     * Establece el panel para campos extra 1.
     * @param campoExtra1 Panel para campos extra 1.
     */
    public void setCampoExtra1(JPanel campoExtra1) {
        this.campoExtra1 = campoExtra1;
    }
    /**
     * Devuelve el panel para campos extra 2.
     * @return JPanel Panel para campos extra 2.
     */
    public JPanel getCampoExtra2() {
        return campoExtra2;
    }
    /**
     * Establece el panel para campos extra 2.
     * @param campoExtra2 Panel para campos extra 2.
     */
    public void setCampoExtra2(JPanel campoExtra2) {
        this.campoExtra2 = campoExtra2;
    }
    /**
     * Devuelve la etiqueta del título.
     * @return JLabel Etiqueta del título.
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }
    /**
     * Establece la etiqueta del título.
     * @param lblTitulo Etiqueta del título.
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }


}