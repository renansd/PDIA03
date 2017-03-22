package pacote26671.CONTROL;

import pacote26671.CONTROL.CtrlGeral;
import pacote26671.VIEW.ViewTela;

public class main {

	public static void main(String[] args) {
		CtrlGeral ctrl = new CtrlGeral();
		ViewTela tela = new ViewTela(ctrl);
		ctrl.view(tela);

	}

}

