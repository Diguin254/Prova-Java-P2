package app;

import app.CadastroPadrao;
import cadastro.PainelBairros;
import cadastro.PainelCarrinho;
import cadastro.PainelCartao;
import cadastro.PainelCliente;
import cadastro.PainelCupom;
import cadastro.PainelDelivery;
import cadastro.PainelDinheiro;
import cadastro.PainelEndereco;
import cadastro.PainelEntrega;
import cadastro.PainelFuncionario;
import cadastro.PainelIngredienteAdicional;
import cadastro.PainelIngredienteEscolha;
import cadastro.PainelIngredienteRemover;
import cadastro.PainelLogin;
import cadastro.PainelMetPagamento;
import cadastro.PainelPagamento;
import cadastro.PainelPedido;
import cadastro.PainelProduto;
import cadastro.PainelReembolso;
import cadastro.PainelStatusPedido;
import cadastro.PainelTaxaEntrega;
import cadastro.PainelTelefone;
import controller.BairroController;
import controller.CarrinhoController;
import controller.CartaoController;
import controller.ClienteController;
import controller.CupomController;
import controller.DeliveryController;
import controller.DinheiroController;
import controller.EnderecoController;
import controller.EntregaController;
import controller.FuncionarioController;
import controller.IngredienteAdicionalController;
import controller.IngredienteEscolhaController;
import controller.IngredienteRemoverController;
import controller.LoginController;
import controller.MetodoPagamentoController;
import controller.PagamentoController;
import controller.PedidoController;
import controller.ProdutoController;
import controller.ReembolsoController;
import controller.StatusPedidoController;
import controller.TaxaEntregaController;
import controller.TelefoneController;
import dto.InterfaceDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import listagem.ListagemAdicional;
import listagem.ListagemBairro;
import listagem.ListagemCarrinho;
import listagem.ListagemCartao;
import listagem.ListagemCliente;
import listagem.ListagemCupom;
import listagem.ListagemDelivery;
import listagem.ListagemDinheiro;
import listagem.ListagemEndereco;
import listagem.ListagemEntrega;
import listagem.ListagemEscolha;
import listagem.ListagemFuncionario;
import listagem.ListagemLogin;
import listagem.ListagemMetPag;
import listagem.ListagemPagamento;
import listagem.ListagemPedido;
import listagem.ListagemProduto;
import listagem.ListagemReembolso;
import listagem.ListagemRemover;
import listagem.ListagemStatus;
import listagem.ListagemTaxa;
import listagem.ListagemTelefone;

/**
 *
 * @author alenc
 */
public class Principal extends javax.swing.JFrame {

    private final BairroController bairroController = new BairroController();
    private final ClienteController clienteController = new ClienteController();
    private final CarrinhoController carrinhoController = new CarrinhoController();
    private final CartaoController cartaoController = new CartaoController();
    private final CupomController cupomController = new CupomController();
    private final DeliveryController deliveryController = new DeliveryController();
    private final DinheiroController dinheiroController = new DinheiroController();
    private final EnderecoController enderecoController = new EnderecoController();
    private final FuncionarioController funcionarioController = new FuncionarioController();
    private final IngredienteEscolhaController ingredienteEscolhaController = new IngredienteEscolhaController();
    private final LoginController loginController = new LoginController();
    private final MetodoPagamentoController metodoPagamentoController = new MetodoPagamentoController();
    private final PedidoController pedidoController = new PedidoController();
    private final ProdutoController produtoController = new ProdutoController();
    private final StatusPedidoController statusPedidoController = new StatusPedidoController();

    public Principal() {
        initComponents();
        setSize(600, 400);
        setLocationRelativeTo(null);
        atualizarHora();
        setVisible(true);
    }

    private void atualizarHora() {
        Timer timer = new Timer(1000, e -> { // Cria um Timer para atualizar a cada segundo
            Date dataHoraAtual = new Date();
            String horaFormatada = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

            // Atualiza o JLabel utilizando SwingUtilities.invokeLater
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jhora.setText(horaFormatada);
                }
            });
        });
        timer.start(); // Inicia o Timer
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSair = new javax.swing.JButton();
        jhora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemBairro = new javax.swing.JMenuItem();
        jMenuItemCarrinho = new javax.swing.JMenuItem();
        jMenuItemCartao = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemCupom = new javax.swing.JMenuItem();
        jMenuItemDelivery = new javax.swing.JMenuItem();
        jMenuItemDinheiro = new javax.swing.JMenuItem();
        jMenuItemEndereco = new javax.swing.JMenuItem();
        jMenuItemEntrega = new javax.swing.JMenuItem();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenuItemAdicional = new javax.swing.JMenuItem();
        jMenuItemEscolha = new javax.swing.JMenuItem();
        jMenuItemRemover = new javax.swing.JMenuItem();
        jMenuItemLogin = new javax.swing.JMenuItem();
        jMenuItemMetPagamento = new javax.swing.JMenuItem();
        jMenuItemPagamento = new javax.swing.JMenuItem();
        jMenuItemPedido = new javax.swing.JMenuItem();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenuItemReembolso = new javax.swing.JMenuItem();
        jMenuItemStatusPedido = new javax.swing.JMenuItem();
        jMenuItemTaxaEntrega = new javax.swing.JMenuItem();
        jMenuItemTelefone = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuListarBairro = new javax.swing.JMenuItem();
        jMenuListarCarrinho = new javax.swing.JMenuItem();
        jMenuListarCartao = new javax.swing.JMenuItem();
        jMenuListarCliente = new javax.swing.JMenuItem();
        jMenuListarCupom = new javax.swing.JMenuItem();
        jMenuListarDelivery = new javax.swing.JMenuItem();
        jMenuListarDinheiro = new javax.swing.JMenuItem();
        jMenuListarEndereco = new javax.swing.JMenuItem();
        jMenuListarEntrega = new javax.swing.JMenuItem();
        jMenuListarFuncionario = new javax.swing.JMenuItem();
        jMenuListarAdicional = new javax.swing.JMenuItem();
        jMenuListarEscolha = new javax.swing.JMenuItem();
        jMenuListarRemover = new javax.swing.JMenuItem();
        jMenuListarLogin = new javax.swing.JMenuItem();
        jMenuListarMetPag = new javax.swing.JMenuItem();
        jMenuListarPagamento = new javax.swing.JMenuItem();
        jMenuListarPedido = new javax.swing.JMenuItem();
        jMenuListarProduto = new javax.swing.JMenuItem();
        jMenuListarReembolso = new javax.swing.JMenuItem();
        jMenuListarStatus = new javax.swing.JMenuItem();
        jMenuListarTaxa = new javax.swing.JMenuItem();
        jMenuListarTelefone = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        jPanel1.add(jbSair);

        jhora.setText("Hora");
        jPanel1.add(jhora);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Cadastros");

        jMenuItemBairro.setText("Bairro");
        jMenuItemBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBairroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemBairro);

        jMenuItemCarrinho.setText("Carrinho");
        jMenuItemCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarrinhoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCarrinho);

        jMenuItemCartao.setText("Cartão");
        jMenuItemCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCartaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCartao);

        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCliente);

        jMenuItemCupom.setText("Cupom");
        jMenuItemCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCupomActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCupom);

        jMenuItemDelivery.setText("Delivery");
        jMenuItemDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeliveryActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDelivery);

        jMenuItemDinheiro.setText("Dinheiro");
        jMenuItemDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDinheiroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDinheiro);

        jMenuItemEndereco.setText("Endereço");
        jMenuItemEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnderecoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEndereco);

        jMenuItemEntrega.setText("Entrega");
        jMenuItemEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEntregaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEntrega);

        jMenuItemFuncionario.setText("Funcionario");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemFuncionario);

        jMenuItemAdicional.setText("Ingrediente Adicional");
        jMenuItemAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdicionalActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemAdicional);

        jMenuItemEscolha.setText("Ingrediente Escolha");
        jMenuItemEscolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEscolhaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEscolha);

        jMenuItemRemover.setText("Ingrediente Remover");
        jMenuItemRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRemover);

        jMenuItemLogin.setText("Login");
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemLogin);

        jMenuItemMetPagamento.setText("Metodo de Pagamento");
        jMenuItemMetPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMetPagamentoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemMetPagamento);

        jMenuItemPagamento.setText("Pagamento");
        jMenuItemPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagamentoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPagamento);

        jMenuItemPedido.setText("Pedido");
        jMenuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPedido);

        jMenuItemProduto.setText("Produto");
        jMenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemProduto);

        jMenuItemReembolso.setText("Reembolso");
        jMenuItemReembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReembolsoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemReembolso);

        jMenuItemStatusPedido.setText("Status do Pedido");
        jMenuItemStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStatusPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemStatusPedido);

        jMenuItemTaxaEntrega.setText("Taxa de Entrega");
        jMenuItemTaxaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTaxaEntregaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemTaxaEntrega);

        jMenuItemTelefone.setText("Telefone");
        jMenuItemTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelefoneActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemTelefone);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Listar - Editar - Remover");

        jMenuListarBairro.setText("Bairro");
        jMenuListarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarBairroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarBairro);

        jMenuListarCarrinho.setText("Carrinho");
        jMenuListarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarCarrinhoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarCarrinho);

        jMenuListarCartao.setText("Cartão");
        jMenuListarCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarCartaoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarCartao);

        jMenuListarCliente.setText("Cliente");
        jMenuListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarCliente);

        jMenuListarCupom.setText("Cupom");
        jMenuListarCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarCupomActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarCupom);

        jMenuListarDelivery.setText("Delivery");
        jMenuListarDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarDeliveryActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarDelivery);

        jMenuListarDinheiro.setText("Dinheiro");
        jMenuListarDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarDinheiroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarDinheiro);

        jMenuListarEndereco.setText("Endereço");
        jMenuListarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarEnderecoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarEndereco);

        jMenuListarEntrega.setText("Entrega");
        jMenuListarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarEntregaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarEntrega);

        jMenuListarFuncionario.setText("Funcionário");
        jMenuListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarFuncionario);

        jMenuListarAdicional.setText("Ingrediente Adicional");
        jMenuListarAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarAdicionalActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarAdicional);

        jMenuListarEscolha.setText("Ingrediente Escolha");
        jMenuListarEscolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarEscolhaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarEscolha);

        jMenuListarRemover.setText("Ingrediente Remover");
        jMenuListarRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarRemoverActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarRemover);

        jMenuListarLogin.setText(" Login");
        jMenuListarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarLogin);

        jMenuListarMetPag.setText("Método de Pagamento");
        jMenuListarMetPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarMetPagActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarMetPag);

        jMenuListarPagamento.setText("Pagamento");
        jMenuListarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarPagamentoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarPagamento);

        jMenuListarPedido.setText("Pedido");
        jMenuListarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarPedido);

        jMenuListarProduto.setText("Produto");
        jMenuListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarProduto);

        jMenuListarReembolso.setText("Reembolso");
        jMenuListarReembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarReembolsoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarReembolso);

        jMenuListarStatus.setText("Status do Pedido");
        jMenuListarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarStatusActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarStatus);

        jMenuListarTaxa.setText("Taxa de Entrega");
        jMenuListarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarTaxaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarTaxa);

        jMenuListarTelefone.setText("Telefone");
        jMenuListarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarTelefoneActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuListarTelefone);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSairActionPerformed

    private void jMenuItemBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBairroActionPerformed
        new CadastroPadrao(this, new PainelBairros(), new BairroController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemBairroActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        new CadastroPadrao(this, new PainelCliente(), new ClienteController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        try {
            List<InterfaceDTO> listaLoginDTO = loginController.listar();
            if (listaLoginDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Funcionario.\nNão existe nenhum Login cadastrado.\nCadastre um Login antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelFuncionario(), new FuncionarioController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Login:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    private void jMenuItemEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnderecoActionPerformed
        try {
            List<InterfaceDTO> listaBairrosDTO = bairroController.listar();
            if (listaBairrosDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Endereço.\nNão existe nenhum Bairro cadastrado.\nCadastre um Bairro antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelEndereco(), new EnderecoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Bairros:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemEnderecoActionPerformed

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        new CadastroPadrao(this, new PainelLogin(), new LoginController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jMenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutoActionPerformed
        new CadastroPadrao(this, new PainelProduto(), new ProdutoController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemProdutoActionPerformed

    private void jMenuItemTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelefoneActionPerformed
        try {
            List<InterfaceDTO> listaClienteDTO = clienteController.listar();
            List<InterfaceDTO> listaFuncionarioDTO = funcionarioController.listar();
            if (listaClienteDTO.isEmpty() || listaFuncionarioDTO.isEmpty()) {
                if (listaClienteDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Telefone.\nNão existe nenhum Cliente cadastrado.\nCadastre um Cliente antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaFuncionarioDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Telefone.\nNão existe nenhum Funcionário cadastrado.\nCadastre um Funcionário antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelTelefone(), new TelefoneController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Cliente - Funcionário:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemTelefoneActionPerformed

    private void jMenuItemCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarrinhoActionPerformed
        try {
            List<InterfaceDTO> listaPedidosDTO = pedidoController.listar();
            List<InterfaceDTO> listaProdutosDTO = produtoController.listar();
            if (listaPedidosDTO.isEmpty() || listaProdutosDTO.isEmpty()) {
                if (listaPedidosDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Carrinho.\nNão existe nenhum Pedido cadastrado.\nCadastre um Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaProdutosDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Carrinho.\nNão existe nenhum Produto cadastrado.\nCadastre um Produto antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelCarrinho(), new CarrinhoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Pedidos/Produtos:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemCarrinhoActionPerformed

    private void jMenuItemAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdicionalActionPerformed
        try {
            List<InterfaceDTO> listaAdicionaisDTO = ingredienteEscolhaController.listar();
            if (listaAdicionaisDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Ingrediente Adicional.\nNão existe nenhum Ingrediente cadastrado.\nCadastre um Ingrediente antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelIngredienteAdicional(), new IngredienteAdicionalController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Ingredientes:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemAdicionalActionPerformed

    private void jMenuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPedidoActionPerformed
        try {
            List<InterfaceDTO> listaClienteDTO = clienteController.listar();
            List<InterfaceDTO> listaStatusPedidoDTO = statusPedidoController.listar();
            if (listaClienteDTO.isEmpty() || listaStatusPedidoDTO.isEmpty()) {
                if (listaClienteDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Pedido.\nNão existe nenhum Cliente cadastrado.\nCadastre um Cliente antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaStatusPedidoDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Pedido.\nNão existe nenhum Status de Pedido cadastrado.\nCadastre um Status de Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelPedido(), new PedidoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Cliente - Status de Pedido:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemPedidoActionPerformed

    private void jMenuItemStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStatusPedidoActionPerformed
            new CadastroPadrao(this, new PainelStatusPedido(), new StatusPedidoController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemStatusPedidoActionPerformed

    private void jMenuItemCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCupomActionPerformed
        new CadastroPadrao(this, new PainelCupom(), new CupomController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemCupomActionPerformed

    private void jMenuItemDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeliveryActionPerformed
        try {
            List<InterfaceDTO> listaEnderecoDTO = enderecoController.listar();
            if (listaEnderecoDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Delivery.\nNão existe nenhum Endereço cadastrado.\nCadastre um Endereço antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelDelivery(), new DeliveryController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Endereços:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemDeliveryActionPerformed

    private void jMenuItemDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDinheiroActionPerformed
        new CadastroPadrao(this, new PainelDinheiro(), new DinheiroController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemDinheiroActionPerformed

    private void jMenuItemEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEntregaActionPerformed
        try {
            List<InterfaceDTO> listaDeliverysDTO = deliveryController.listar();
            List<InterfaceDTO> listaClientesDTO = clienteController.listar();
            List<InterfaceDTO> listaPedidosDTO = pedidoController.listar();
            List<InterfaceDTO> listaStatusPedidosDTO = statusPedidoController.listar();
            if (listaDeliverysDTO.isEmpty() || listaClientesDTO.isEmpty() || listaPedidosDTO.isEmpty() || listaStatusPedidosDTO.isEmpty()) {
                if (listaDeliverysDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Entrega.\nNão existe nenhum Delivery cadastrado.\nCadastre um Delivery antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaClientesDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Entrega.\nNão existe nenhum Cliente cadastrado.\nCadastre um Cliente antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaPedidosDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Entrega.\nNão existe nenhum Pedido cadastrado.\nCadastre um Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaStatusPedidosDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Entrega.\nNão existe nenhum Status de Pedido cadastrado.\nCadastre um Status de Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelEntrega(), new EntregaController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Delivery - Cliente - Pedido - Status do Pedido:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemEntregaActionPerformed

    private void jMenuItemEscolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEscolhaActionPerformed
        try {
            List<InterfaceDTO> listaCarrinhosDTO = carrinhoController.listar();
            if (listaCarrinhosDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Escolha de Ingrediente.\nNão existe nenhum Carrinho cadastrado.\nCadastre um Carrinho antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelIngredienteEscolha(), new IngredienteEscolhaController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Escolha de Ingrediente:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemEscolhaActionPerformed

    private void jMenuItemRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverActionPerformed
        try {
            List<InterfaceDTO> listaIngredientesDTO = ingredienteEscolhaController.listar();
            if (listaIngredientesDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Remoção de Ingrediente.\nNão existe nenhum Ingrediente cadastrado.\nCadastre um Ingrediente antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelIngredienteRemover(), new IngredienteRemoverController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Remoção de Ingrediente:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemRemoverActionPerformed

    private void jMenuItemMetPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMetPagamentoActionPerformed
        try {
            List<InterfaceDTO> listaDinheiroDTO = dinheiroController.listar();
            List<InterfaceDTO> listaCartaoDTO = cartaoController.listar();
            if (listaDinheiroDTO.isEmpty() || listaCartaoDTO.isEmpty()) {
                if (listaDinheiroDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Metodo de Pagamento.\nNão existe nenhum Dinheiro cadastrado.\nCadastre um Dinheiro antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaCartaoDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Metodo de Pagamento.\nNão existe nenhum Cartao cadastrado.\nCadastre um Cartao antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelMetPagamento(), new MetodoPagamentoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Dinheiro/Cartao:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemMetPagamentoActionPerformed

    private void jMenuItemPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagamentoActionPerformed
        try {
            List<InterfaceDTO> listaMetPagDTO = metodoPagamentoController.listar();
            List<InterfaceDTO> listaCupomDTO = cupomController.listar();
            List<InterfaceDTO> listaPedidoDTO = pedidoController.listar();
            if (listaMetPagDTO.isEmpty() || listaCupomDTO.isEmpty() || listaPedidoDTO.isEmpty()) {
                if (listaMetPagDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Pagamento.\nNão existe nenhum Metodo de Pagamento cadastrado.\nCadastre um Metodo de Pagamento antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaCupomDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Pagamento.\nNão existe nenhum Cupom cadastrado.\nCadastre um Cupom antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if (listaPedidoDTO.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Pagamento.\nNão existe nenhum Pedido cadastrado.\nCadastre um Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            new CadastroPadrao(this, new PainelPagamento(), new PagamentoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Metodo de Pagamento - Cupom - Pedido:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemPagamentoActionPerformed

    private void jMenuItemReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReembolsoActionPerformed
        try {
            List<InterfaceDTO> listaPedidoDTO = pedidoController.listar();
            if (listaPedidoDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Reembolso.\nNão existe nenhum Pedido cadastrado.\nCadastre um Pedido antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelReembolso(), new ReembolsoController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Pedidos:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItemReembolsoActionPerformed

    private void jMenuItemTaxaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTaxaEntregaActionPerformed
        try {
            List<InterfaceDTO> listaEnderecoDTO = enderecoController.listar();
            if (listaEnderecoDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não é possível abrir o cadastro de Taxa de Entrega.\nNão existe nenhum Endereço cadastrado.\nCadastre um Endereço antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new CadastroPadrao(this, new PainelTaxaEntrega(), new TaxaEntregaController(), true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao verificar existência de Endereços:\n" + ex.getMessage(),
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        
    }//GEN-LAST:event_jMenuItemTaxaEntregaActionPerformed

    private void jMenuItemCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCartaoActionPerformed
        new CadastroPadrao(this, new PainelCartao(), new CartaoController(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemCartaoActionPerformed

    private void jMenuListarDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarDinheiroActionPerformed
       ListagemDinheiro dialog = new ListagemDinheiro(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarDinheiroActionPerformed

    private void jMenuListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarClienteActionPerformed
        ListagemCliente dialog = new ListagemCliente(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarClienteActionPerformed

    private void jMenuListarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarBairroActionPerformed
        ListagemBairro dialog = new ListagemBairro(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarBairroActionPerformed

    private void jMenuListarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarCarrinhoActionPerformed
        ListagemCarrinho dialog = new ListagemCarrinho(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarCarrinhoActionPerformed

    private void jMenuListarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarCartaoActionPerformed
        ListagemCartao dialog = new ListagemCartao(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarCartaoActionPerformed

    private void jMenuListarCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarCupomActionPerformed
        ListagemCupom dialog = new ListagemCupom(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarCupomActionPerformed

    private void jMenuListarDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarDeliveryActionPerformed
        ListagemDelivery dialog = new ListagemDelivery(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarDeliveryActionPerformed

    private void jMenuListarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarEnderecoActionPerformed
        ListagemEndereco dialog = new ListagemEndereco(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarEnderecoActionPerformed

    private void jMenuListarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarEntregaActionPerformed
        ListagemEntrega dialog = new ListagemEntrega(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarEntregaActionPerformed

    private void jMenuListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarFuncionarioActionPerformed
        ListagemFuncionario dialog = new ListagemFuncionario(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarFuncionarioActionPerformed

    private void jMenuListarAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarAdicionalActionPerformed
        ListagemAdicional dialog = new ListagemAdicional(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarAdicionalActionPerformed

    private void jMenuListarEscolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarEscolhaActionPerformed
       ListagemEscolha dialog = new ListagemEscolha(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarEscolhaActionPerformed

    private void jMenuListarRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarRemoverActionPerformed
        ListagemRemover dialog = new ListagemRemover(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarRemoverActionPerformed

    private void jMenuListarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarLoginActionPerformed
        ListagemLogin dialog = new ListagemLogin(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarLoginActionPerformed

    private void jMenuListarMetPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarMetPagActionPerformed
        ListagemMetPag dialog = new ListagemMetPag(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarMetPagActionPerformed

    private void jMenuListarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarPagamentoActionPerformed
        ListagemPagamento dialog = new ListagemPagamento(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarPagamentoActionPerformed

    private void jMenuListarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarPedidoActionPerformed
        ListagemPedido dialog = new ListagemPedido(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarPedidoActionPerformed

    private void jMenuListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarProdutoActionPerformed
        ListagemProduto dialog = new ListagemProduto(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarProdutoActionPerformed

    private void jMenuListarReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarReembolsoActionPerformed
        ListagemReembolso dialog = new ListagemReembolso(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarReembolsoActionPerformed

    private void jMenuListarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarStatusActionPerformed
        ListagemStatus dialog = new ListagemStatus(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarStatusActionPerformed

    private void jMenuListarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarTaxaActionPerformed
        ListagemTaxa dialog = new ListagemTaxa(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarTaxaActionPerformed

    private void jMenuListarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarTelefoneActionPerformed
        ListagemTelefone dialog = new ListagemTelefone(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuListarTelefoneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdicional;
    private javax.swing.JMenuItem jMenuItemBairro;
    private javax.swing.JMenuItem jMenuItemCarrinho;
    private javax.swing.JMenuItem jMenuItemCartao;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemCupom;
    private javax.swing.JMenuItem jMenuItemDelivery;
    private javax.swing.JMenuItem jMenuItemDinheiro;
    private javax.swing.JMenuItem jMenuItemEndereco;
    private javax.swing.JMenuItem jMenuItemEntrega;
    private javax.swing.JMenuItem jMenuItemEscolha;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenuItem jMenuItemMetPagamento;
    private javax.swing.JMenuItem jMenuItemPagamento;
    private javax.swing.JMenuItem jMenuItemPedido;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JMenuItem jMenuItemReembolso;
    private javax.swing.JMenuItem jMenuItemRemover;
    private javax.swing.JMenuItem jMenuItemStatusPedido;
    private javax.swing.JMenuItem jMenuItemTaxaEntrega;
    private javax.swing.JMenuItem jMenuItemTelefone;
    private javax.swing.JMenuItem jMenuListarAdicional;
    private javax.swing.JMenuItem jMenuListarBairro;
    private javax.swing.JMenuItem jMenuListarCarrinho;
    private javax.swing.JMenuItem jMenuListarCartao;
    private javax.swing.JMenuItem jMenuListarCliente;
    private javax.swing.JMenuItem jMenuListarCupom;
    private javax.swing.JMenuItem jMenuListarDelivery;
    private javax.swing.JMenuItem jMenuListarDinheiro;
    private javax.swing.JMenuItem jMenuListarEndereco;
    private javax.swing.JMenuItem jMenuListarEntrega;
    private javax.swing.JMenuItem jMenuListarEscolha;
    private javax.swing.JMenuItem jMenuListarFuncionario;
    private javax.swing.JMenuItem jMenuListarLogin;
    private javax.swing.JMenuItem jMenuListarMetPag;
    private javax.swing.JMenuItem jMenuListarPagamento;
    private javax.swing.JMenuItem jMenuListarPedido;
    private javax.swing.JMenuItem jMenuListarProduto;
    private javax.swing.JMenuItem jMenuListarReembolso;
    private javax.swing.JMenuItem jMenuListarRemover;
    private javax.swing.JMenuItem jMenuListarStatus;
    private javax.swing.JMenuItem jMenuListarTaxa;
    private javax.swing.JMenuItem jMenuListarTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jhora;
    // End of variables declaration//GEN-END:variables

}
