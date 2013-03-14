/*
 * TournamentProgressUI2.java
 *
 * Created on 9 september 2008, 12:13
 */

package negotiator.gui.progress;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import negotiator.NegotiationEventListener;
import negotiator.actions.Accept;
import negotiator.actions.EndNegotiation;
import negotiator.events.ActionEvent;
import negotiator.events.BilateralAtomicNegotiationSessionEvent;
import negotiator.events.LogMessageEvent;
import negotiator.events.NegotiationEndedEvent;
import negotiator.events.NegotiationSessionEvent;
import negotiator.gui.NegoGUIApp;

import negotiator.protocol.BilateralAtomicNegotiationSession;
import negotiator.protocol.Protocol;
import negotiator.tournament.VariablesAndValues.AgentParamValue;
import negotiator.tournament.VariablesAndValues.AgentParameterVariable;

import java.util.Hashtable;

/**
 *
 * @author  Dima
 */
public class TournamentProgressUI2 extends javax.swing.JPanel implements NegotiationEventListener{
	private NegoTableModel resultTableModel; // the table model	
	private BilateralAtomicNegotiationSession negoSession;
	private ArrayList <BilateralAtomicNegotiationSession> sessionArray;
	private int session;
	private ProgressUI2 sessionProgress;
	private ProgressUI2 oldUI;
	
	/** modified Wouter 4nov08: SesssionDetailsUI contains list of pairs <session number, ProgressUI> */
	private Hashtable<Integer,ProgressUI2> SessionDetailsUI=new Hashtable<Integer,ProgressUI2>();
	
    /** Creates new form TournamentProgressUI2 */
    public TournamentProgressUI2(ProgressUI2 pUI) {
    	sessionArray = new ArrayList<BilateralAtomicNegotiationSession>();
    	jPanel1 = pUI;
        initComponents(); 
		sessionProgress = pUI;
		negoSession = pUI.session;
		String[] colNames={"Domain1","Domain2","AgentA","AgentB","AgentA params","AgentB params","Rounds","utilA","utilB","Details"};
		resultTableModel = new NegoTableModel (colNames);
		resultTable.setModel(resultTableModel);
		//add a listener to receive selection events:
	    MyListSelectionListener listener = new MyListSelectionListener(resultTable);
	    resultTable.getSelectionModel().addListSelectionListener(listener);
	    resultTable.getColumnModel().getSelectionModel()
	        .addListSelectionListener(listener);		
		//pnlSession.add(sessionProgress);
	   
	    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pnlTournamentOverView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        pnlSession = new javax.swing.JPanel();
       // jPanel1 = new javax.swing.JPanel();

        setName("Form"); // NOI18N

        jSplitPane1.setDividerSize(3);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(negotiator.gui.NegoGUIApp.class).getContext().getResourceMap(TournamentProgressUI2.class);
        pnlTournamentOverView.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("pnlTournamentOverView.border.title"))); // NOI18N
        pnlTournamentOverView.setName("pnlTournamentOverView"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        resultTable.setName("resultTable"); // NOI18N
        jScrollPane1.setViewportView(resultTable);

        org.jdesktop.layout.GroupLayout pnlTournamentOverViewLayout = new org.jdesktop.layout.GroupLayout(pnlTournamentOverView);
        pnlTournamentOverView.setLayout(pnlTournamentOverViewLayout);
        pnlTournamentOverViewLayout.setHorizontalGroup(
            pnlTournamentOverViewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        pnlTournamentOverViewLayout.setVerticalGroup(
            pnlTournamentOverViewLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(pnlTournamentOverView);

        pnlSession.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("pnlSession.border.title"))); // NOI18N
        pnlSession.setName("pnlSession"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

//        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//            .add(0, 390, Short.MAX_VALUE)
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//            .add(0, 221, Short.MAX_VALUE)
//        );

        org.jdesktop.layout.GroupLayout pnlSessionLayout = new org.jdesktop.layout.GroupLayout(pnlSession);
        pnlSession.setLayout(pnlSessionLayout);
        pnlSessionLayout.setHorizontalGroup(
            pnlSessionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSessionLayout.setVerticalGroup(
            pnlSessionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(pnlSession);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlSession;
    private javax.swing.JPanel pnlTournamentOverView;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
	public void handleActionEvent(ActionEvent evt) {
		//System.out.println("Caught event "+evt+ "in TournamentProgressUI");	
		if ((evt.getAction() instanceof EndNegotiation)|| (evt.getAction()instanceof Accept)){
			//System.out.println("end or accept --> fill table");
			resultTable.getModel().setValueAt(evt.getRound(),session-1,6);//rounds
			resultTable.getModel().setValueAt(evt.getNormalizedUtilityA(),session-1,7);//util a
			resultTable.getModel().setValueAt(evt.getNormalizedUtilityB(),session-1,8);//util b
			resultTable.getModel().setValueAt("",session-1,9);//details???
		}
	}

	public void handleLogMessageEvent(LogMessageEvent evt) {
		//System.out.println("Caught event "+evt+ "in TournamentProgressUI");	
	}

	public void handleBlateralAtomicNegotiationSessionEvent(
			BilateralAtomicNegotiationSessionEvent evt) {
		//System.out.println("Caught event "+evt+ "in TournamentProgressUI");	
		session+=1;
		if(session>resultTable.getModel().getRowCount()){
			resultTableModel.addRow();
		}
		//fill the table
		String agentAParams="";String agentBParams="";
		negoSession = evt.getSession();
		sessionProgress.session = negoSession;
		//if(negoSession.sessionTestNumber<1)
		negoSession.addNegotiationEventListener(sessionProgress);
		
		//add the current session to the array
		sessionArray.add(negoSession);
		
		int i=0;
		if(!(negoSession.getAgentAparams()==null)) {
			for(Entry<AgentParameterVariable,AgentParamValue> entry: negoSession.getAgentAparams().entrySet()) 
				{agentAParams+= entry.getKey().varToString() + " " + entry.getValue().toString(); i++;}
			resultTable.getModel().setValueAt(agentAParams,session-1,4);//agent a param
		}
		i=0;
		if(!(negoSession.getAgentBparams()==null)) {
			for(Entry<AgentParameterVariable,AgentParamValue> entry: negoSession.getAgentBparams().entrySet()) 
				{agentBParams+= entry.getKey().varToString() + " " + entry.getValue().toString(); i++;}
			resultTable.getModel().setValueAt(agentBParams,session-1,5);//agent a param
		}
		resultTable.getModel().setValueAt(evt.getProfileA().toString(),session-1,0);//profile 1
		resultTable.getModel().setValueAt(evt.getProfileB().toString(),session-1,1);//profile 2
		resultTable.getModel().setValueAt(evt.getAgentA().getName(),session-1,2);//agent a
		resultTable.getModel().setValueAt(evt.getAgentB().getName(),session-1,3);//agent b
	    
		//clear the ProgressGUI
		//System.out.println("resetting the GUI after NegotiationSessionEvent.");
		sessionProgress.resetGUI();
		sessionProgress.setNegotiationSession(negoSession);
		
	}

	public void handleNegotiationSessionEvent(NegotiationSessionEvent evt) {
		
	}
	
	public class MyListSelectionListener implements ListSelectionListener {
        JTable table;
        // It is necessary to keep the table since it is not possible
        // to determine the table from the event's source
        MyListSelectionListener(JTable table) {
            this.table = table;
        }
        public void valueChanged(ListSelectionEvent e) {
            if (e.getSource() == table.getSelectionModel()
                  && table.getRowSelectionAllowed()) {
                int row = table.getSelectedRow();
                //System.out.println("selection event happened;row "+row+" selected.");
                //show ProgressUI for selected session:
                BilateralAtomicNegotiationSession ng =  sessionArray.get(row);
                //System.out.println(ng.getLog());
                int selected_session_nr=ng.getSessionNumber();
                int selected_test_nr=ng.getTestNumber();

                
                ProgressUI2 ui=SessionDetailsUI.get(row);
                if (ui==null) { /* not there yet, make it */
                	ui=new ProgressUI2(); 
                	ui.fillGUI(ng);
                    SessionDetailsUI.put(row,ui);
                }
                 /* make it visible or select it */
                int index= NegoGUIApp.negoGUIView.getMainTabbedPane().indexOfComponent(ui);
                if (index==-1) { /* not in the tabs, make new tab */
                	String tabname;
            		int tournr=ng.getTournamentNumber();
            		if (tournr!=-1) tabname= "Tour."+tournr+" Prog."+selected_session_nr+"."+selected_test_nr;
            		else tabname= "Sess."+selected_session_nr+"."+selected_test_nr+" Prog.";

                    NegoGUIApp.negoGUIView.addTab(tabname, ui);
                	//oldUI = selectedSessionUI; 
                	//fillGUI(ng);
                    //NegoGUIApp.negoGUIView.replaceTab(getTabString(), oldUI,selectedSessionUI);
                }else{ /* already in the tabs, select it */
                	NegoGUIApp.negoGUIView.getMainTabbedPane().setSelectedComponent(ui);                	
                }    
            }
        }

    }

	/* (non-Javadoc)
	 * @see negotiator.NegotiationEventListener#handleNegotiationEndedEvent(negotiator.events.NegotiationEndedEvent)
	 */
	public void handleNegotiationEndedEvent(NegotiationEndedEvent evt) {
		resultTable.getModel().setValueAt(sessionProgress.session.getNrOfBids(),session-1,6);//rounds
		resultTable.getModel().setValueAt(evt.getUtilityA(),session-1,7);//util a
		resultTable.getModel().setValueAt(evt.getUtilityA(),session-1,8);//util b
		resultTable.getModel().setValueAt(evt.getRemarks(),session-1,9);//details???
		
	}


	
}