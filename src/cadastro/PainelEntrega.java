/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cadastro;

import app.InterfacePainel;
import dao.ClienteDao;
import dao.DeliveryDao;
import dao.PedidoDao;
import dao.StatusPedidoDao;
import dto.EntregaDTO;
import dto.InterfaceDTO;
import implementsDao.ClienteImplementsDAO;
import implementsDao.DeliveryImplementsDAO;
import implementsDao.PedidoImplementsDAO;
import implementsDao.StatusPedidoImplementsDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Delivery;
import model.Pedido;
import model.StatusPedido;

/**
 *
 * @author alenc
 */
public class PainelEntrega extends InterfacePainel {

    /**
     * Creates new form PainelEntrega
     */
    private final ClienteDao clienteDao = new ClienteImplementsDAO();
    private final DeliveryDao deliveryDao = new DeliveryImplementsDAO();
    private final PedidoDao pedidoDao = new PedidoImplementsDAO();
    private final StatusPedidoDao statusDao = new StatusPedidoImplementsDAO();

    private List<Cliente> listaCliente;
    private List<Delivery> listaDelivery;
    private List<Pedido> listaPedido;
    private List<StatusPedido> listaStatus;

    EntregaDTO dto;

    private final String[] tiposTexto = {
        "Entrega Especial",
        "Entrega Simples",
        "Entrega Urgente",
        "Outro tipo"
    };

    private final int[] tiposCodigo = {
        1,
        2,
        3,
        4
    };

    public PainelEntrega() {
        initComponents();
        carregarComboCliente();
        carregarComboDelivery();
        carregarComboPedido();
        carregarComboStatus();
        comboEntrega.removeAllItems();
        for (String txt : tiposTexto) {
            comboEntrega.addItem(txt);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxPedido = new javax.swing.JComboBox<>();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxDelivery = new javax.swing.JComboBox<>();
        comboEntrega = new javax.swing.JComboBox<>();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cliente");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipo de Entrega");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Delivery");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pedido");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Status do Pedido");

        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(comboEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEntrega;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxDelivery;
    private javax.swing.JComboBox<String> jComboBoxPedido;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    @Override
    public InterfaceDTO getDados() {
        if (dto == null) {
            dto = new EntregaDTO();
        }

        int indice = comboEntrega.getSelectedIndex();
        if (indice >= 0 && indice < tiposCodigo.length) {
            dto.tipoEntregaE = String.valueOf(tiposCodigo[indice]);
        } else {
            dto.tipoEntregaE = "0";
        }

        int indiceC = jComboBoxCliente.getSelectedIndex();
        if (indiceC > 0 && indiceC <= listaCliente.size()) {
            Cliente escolhido = listaCliente.get(indiceC - 1);
            dto.idCliente = String.valueOf(escolhido.getId());
        } else {
            dto.idCliente = null;
        }

        int indiceD = jComboBoxDelivery.getSelectedIndex();
        if (indiceD > 0 && indiceD <= listaDelivery.size()) {
            Delivery escolhido = listaDelivery.get(indiceD - 1);
            dto.idDelivery = String.valueOf(escolhido.getId());
        } else {
            dto.idDelivery = null;
        }

        int indiceP = jComboBoxPedido.getSelectedIndex();
        if (indiceP > 0 && indiceP <= listaPedido.size()) {
            Pedido escolhido = listaPedido.get(indiceP - 1);
            dto.idPedido = String.valueOf(escolhido.getId());
        } else {
            dto.idPedido = null;
        }

        int indiceS = jComboBoxStatus.getSelectedIndex();
        if (indiceS > 0 && indiceS <= listaStatus.size()) {
            StatusPedido escolhido = listaStatus.get(indiceS - 1);
            dto.idStatusPedido = String.valueOf(escolhido.getId());
        } else {
            dto.idStatusPedido = null;
        }

        return dto;
    }

    @Override
    public void setDados(InterfaceDTO dto) {
        if (dto != null) {
            this.dto = (EntregaDTO) dto;
        } else {
            this.dto = new EntregaDTO();
        }

        int codigoAtual;
        try {
            codigoAtual = Integer.parseInt(this.dto.tipoEntregaE);
        } catch (NumberFormatException e) {
            codigoAtual = 0;
        }

        int indiceParaSelecionar = -1;
        for (int i = 0; i < tiposCodigo.length; i++) {
            if (tiposCodigo[i] == codigoAtual) {
                indiceParaSelecionar = i;
                return;
            }
        }

        if (indiceParaSelecionar >= 0) {
            comboEntrega.setSelectedIndex(indiceParaSelecionar);
        } else {
            comboEntrega.setSelectedIndex(-1);
        }

        if (listaCliente != null && !listaCliente.isEmpty() && this.dto.idCliente != null) {
            int idC = Integer.parseInt(this.dto.idCliente);
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getId() == idC) {
                    jComboBoxCliente.setSelectedIndex(i + 1);
                    return;
                }
            }
        }
        jComboBoxCliente.setSelectedIndex(0);
        if (listaDelivery != null && !listaDelivery.isEmpty() && this.dto.idDelivery != null) {
            int indiceD = Integer.parseInt(this.dto.idDelivery);
            for (int i = 0; i < listaDelivery.size(); i++) {
                if (listaDelivery.get(i).getId() == indiceD) {
                    jComboBoxDelivery.setSelectedIndex(i + 1);
                    return;
                }
            }
        }
        jComboBoxDelivery.setSelectedIndex(0);
        
        if (listaPedido != null && !listaPedido.isEmpty() && this.dto.idPedido != null) {
            int indiceP = Integer.parseInt(this.dto.idPedido);
            for (int i = 0; i < listaPedido.size(); i++) {
                if (listaPedido.get(i).getId() == indiceP) {
                    jComboBoxPedido.setSelectedIndex(i + 1);
                    return;
                }
            }
        }
        jComboBoxPedido.setSelectedIndex(0);
        
        if (listaStatus != null && !listaStatus.isEmpty() && this.dto.idStatusPedido != null) {
            int indiceS = Integer.parseInt(this.dto.idStatusPedido);
            for (int i = 0; i < listaStatus.size(); i++) {
                if (listaStatus.get(i).getId() == indiceS) {
                    jComboBoxStatus.setSelectedIndex(i + 1);
                    return;
                }
            }
        }
        jComboBoxStatus.setSelectedIndex(0);
    }

    private void carregarComboCliente() {
        try {
            listaCliente = clienteDao.listar();
            jComboBoxCliente.removeAllItems();
            jComboBoxCliente.addItem("Selecione");
            for (Cliente c : listaCliente) {
                jComboBoxCliente.addItem(c.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar cliente: " + e.getMessage());
        }
    }

    private void carregarComboDelivery() {
        try {
            listaDelivery = deliveryDao.listar();
            jComboBoxDelivery.removeAllItems();
            jComboBoxDelivery.addItem("Selecione");
            for (Delivery d : listaDelivery) {
                jComboBoxDelivery.addItem(d.getChaveEntrega());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar delivery: " + e.getMessage());
        }
    }

    private void carregarComboPedido() {
        try {
            listaPedido = pedidoDao.listar();
            jComboBoxPedido.removeAllItems();
            jComboBoxPedido.addItem("Selecione");
            for (Pedido p : listaPedido) {
                jComboBoxPedido.addItem(String.valueOf(p.getNumeroPedido()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar pedido: " + e.getMessage());
        }
    }

    private void carregarComboStatus() {
        try {
            listaStatus = statusDao.listar();
            jComboBoxStatus.removeAllItems();
            jComboBoxStatus.addItem("Selecione");
            for (StatusPedido sts : listaStatus) {
                jComboBoxStatus.addItem(sts.getProgresso());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar status: " + e.getMessage());
        }
    }
}
