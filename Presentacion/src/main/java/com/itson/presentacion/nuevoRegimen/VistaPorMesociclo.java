// Copyright (c) Andrea Salazar Abigail Cárdenas, Alec Demian Santana Celaya, 
// Carlos Ariel Angulo Campos, Josue Emamnuel Flores Carballo, 
// Jesus Alejandro Izaguirre Gil. Licensed under the MIT Licence.
// See the LICENSE file in the repository root for full license text.
package com.itson.presentacion.nuevoRegimen;

import javax.swing.table.DefaultTableModel;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.table.DefaultTableModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itson.dominio.Etapa;
import com.itson.dominio.Medio;
import com.itson.dominio.Mesociclo;
import com.itson.dominio.Regimen;
import implementaciones.Persistencia;
import interfaces.IPersistencia;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

public class VistaPorMesociclo extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private double totalVolumen;
    private int filas = 1;
    boolean columnasAgregadas = false;
    private Regimen regimen;
    private List<Medio> medios;
    private List<Integer> columnasEditables;
    IPersistencia persistencia;

    public VistaPorMesociclo(IPersistencia persistencia) {
        initComponents();
        columnasEditables = new ArrayList<Integer>();
        crearModeloTabla();
        this.persistencia=persistencia;

    }

    public void llenarTabla() {
        tableModel.setRowCount(0);

        try {
            regimen = persistencia.consultarRegimen();
            medios = regimen.getMedios();

            for (Medio medio : medios) {
                String nombreMedio = medio.getMedio();
                String primer = nombreMedio + "(" + medio.getMedicion() + ")";

                // Calcular el totalVolumen específico para cada "medio"
                double totalVolumen = calcularTotalVolumen(medio);
                medio.setVolumenTotal(totalVolumen);
                Object[] rowDataMedios = {primer, totalVolumen};
                tableModel.addRow(rowDataMedios);
            }
            List<Etapa> etapas = regimen.getEtapas();
            int noEtapa = 0;

            for (Etapa etapa : etapas) {
                int indexMeso = 0;
                List<Mesociclo> mesociclos = etapa.getMesociclos();
                for (Mesociclo mesociclo : mesociclos) {
                    llenarPorcentajesVol(mesociclo, noEtapa, indexMeso);

                    indexMeso++;
                }
                noEtapa++;
            }
            columnasAgregadas = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double calcularTotalVolumen(Medio medio) {
        double totalVolumen = 0.0;

        List<Etapa> etapas = medio.getEtapas();

        for (Etapa etapa : etapas) {

            double volumenEtapa = etapa.getVolumen();
            totalVolumen += volumenEtapa;
        }

        return totalVolumen;
    }

    private boolean llenarPorcentajesVol(Mesociclo mesociclo, int noEtapa, int indexMeso) {
        int numRows = tableModel.getRowCount();

        int noMesociclo = mesociclo.getNoMesociclo();
        if (columnasAgregadas == false) {
            tableModel.addColumn("Mesociclo ");
            tableModel.addColumn("Vol");
            tableModel.addColumn("%");

        }

        columnasEditables.add(tableModel.getColumnCount() - 1);//hace que la columna de porcentaje sea editable

        //inserta valores de todos los medios de un mesociclo
        for (int i = 0; i < numRows; i++) {
            Mesociclo mesoDeMedio = medios.get(i).getEtapas().get(noEtapa).getMesociclos().get(indexMeso);
            tableModel.setValueAt(noMesociclo, i, tableModel.getColumnCount() - 3);//no. de meso
            tableModel.setValueAt(mesoDeMedio.getVolumen(), i, tableModel.getColumnCount() - 2);// volumen de meso
            tableModel.setValueAt(mesoDeMedio.getPorcentaje(), i, tableModel.getColumnCount() - 1);// porcentaje
            
        }
        return columnasAgregadas;
    }

    public void crearModeloTabla() {

        tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int col) {//Modifica el modelo para que las celdas puedan ser editables
                if (columnasEditables.isEmpty()) {
                    return false;
                }
                if (columnasEditables.contains(col)) {
                    return true;
                }
                return false;
            }

            @Override
            public Class<?> getColumnClass(int c) {//Modifica el modelo para que solo acepten números
                if (columnasEditables.isEmpty()) {
                    return Integer.class;
                }
                if (columnasEditables.contains(c)) {
                    return Integer.class;
                }

                return getValueAt(0, c).getClass();
            }
        };
        tableModel.addColumn("Medios Físicos");
        tableModel.addColumn("Volumen total");

        CellEditorListener ChangeNotification = new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {

            }

            public void editingStopped(ChangeEvent e) {
                modificarPorcentajes();
            }
        };
        tbtMesociclos.getTableHeader().setReorderingAllowed(false);
        tbtMesociclos.setModel(tableModel);
        tbtMesociclos.setCellSelectionEnabled(true);
        tbtMesociclos.getDefaultEditor(Integer.class).addCellEditorListener(ChangeNotification);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtMesociclos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 109, 182));
        jLabel5.setText("Vista por mesociclo");

        tbtMesociclos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Medios físicos", "Volumen Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbtMesociclos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbtMesociclos.setGridColor(new java.awt.Color(255, 255, 255));
        tbtMesociclos.setSelectionBackground(new java.awt.Color(5, 109, 182));
        tbtMesociclos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbtMesociclos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbtMesociclos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbtMesociclosMousePressed(evt);
            }
        });
        tbtMesociclos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbtMesociclosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbtMesociclos);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbtMesociclosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtMesociclosMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_tbtMesociclosMousePressed

    private void tbtMesociclosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbtMesociclosKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_tbtMesociclosKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            guardarCambiosPorcentajes();
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(VistaPorMesociclo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void modificarPorcentajes() {
        int columnaSelec = tbtMesociclos.getSelectedColumn();
        int filaSelec = tbtMesociclos.getSelectedRow();

        for (int indexPorcentaje : columnasEditables) {
            int porcentajeIntroducido = (Integer) tbtMesociclos.getValueAt(filaSelec, indexPorcentaje);
            if (porcentajeIntroducido >= 0 & porcentajeIntroducido <= 100) {
                int sumPorcentajes = 0;
                for (int Indexcol : columnasEditables) {
                    sumPorcentajes = sumPorcentajes + (Integer) tbtMesociclos.getValueAt(filaSelec, Indexcol);
                }

                double volumenDelMeso = (medios.get(filaSelec).getVolumenTotal() / sumPorcentajes) * porcentajeIntroducido;

                tbtMesociclos.setValueAt(volumenDelMeso, filaSelec, indexPorcentaje - 1);
                
            } else {
                tbtMesociclos.setValueAt(0, filaSelec, columnaSelec);
            }
        }
        
    }
    
    public void guardarCambiosPorcentajes() throws Exception{
        int noMedio=0;
        for (Medio medio : medios) {
            int noMeso=0;
        
            for (Etapa etapa : medio.getEtapas()) {
                List<Mesociclo> mesociclos = etapa.getMesociclos();
                for (Mesociclo mesociclo : mesociclos) {
                    int porcentaje = (Integer) tbtMesociclos.getValueAt(noMedio, columnasEditables.get(noMeso));
                    double volumen = (Double) tbtMesociclos.getValueAt(noMedio, columnasEditables.get(noMeso)-1);
                    mesociclo.setPorcentaje(porcentaje);
                    mesociclo.setVolumen(volumen);
                    noMeso++;
                }
            }
            noMedio++;
        }
        regimen.setMedios(medios);
        persistencia.guardarRegimen(regimen);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtMesociclos;
    // End of variables declaration//GEN-END:variables
}
