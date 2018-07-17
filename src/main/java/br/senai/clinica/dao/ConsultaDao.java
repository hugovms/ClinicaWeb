package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;

import br.senai.clinica.model.Consulta;

public class ConsultaDao {

	public boolean gravar(Consulta consulta) {
		try {
			Connection con = new Conexao().conectar();
			PreparedStatement consultaSql =
					con.prepareStatement("insert into consulta "
							+ "(data_hora,valor,diagnostico,peso,altura,crv,cod_animal) "
							+ "values (?,?,?,?,?,?,?)");
		consultaSql.setDate(1, new Date(
				Calendar.getInstance().getTimeInMillis()));
		consultaSql.setFloat(2, consulta.getValor());
		consultaSql.setString(3, consulta.getDiagnostico());
		consultaSql.setFloat(4, consulta.getPeso());
		consultaSql.setFloat(5, consulta.getAltura());
		consultaSql.setInt(6, consulta.getVeterinario().getCrv());
		consultaSql.setInt(7, consulta.getAnimal().getCod());
		consultaSql.execute();
		consultaSql.close();
		con.close();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
