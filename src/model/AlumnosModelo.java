package model;

import dto.AlumnoDTO;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnosModelo {

	public void createAlumno(AlumnoDTO alumno) throws SQLException {
		String query = "INSERT INTO alumnos (nombre, id_municipio, familia_numerosa) VALUES (?, ?, ?)";
		Connection connection = DatabaseUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, alumno.getNombre());
		preparedStatement.setInt(2, alumno.getIdMunicipio());
		preparedStatement.setInt(3, alumno.getFamiliaNumerosa());
		preparedStatement.executeUpdate();
		System.out.println("Alumno creado con éxito.");

	}

	public List<AlumnoDTO> readAlumno(String id) throws SQLException {
		String query = "SELECT a.id, a.nombre, m.nombre AS municipio, a.familia_numerosa FROM alumnos a LEFT JOIN municipios m ON a.id_municipio = m.id_municipio WHERE a.id LIKE ?";
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();

		PreparedStatement preparedStatement = DatabaseUtils.getConnection().prepareStatement(query);
		preparedStatement.setString(1, "%" + id + "%");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {

			listaAlumnos.add(new AlumnoDTO(resultSet.getInt("id"), resultSet.getString("nombre"),
					resultSet.getString("municipio"), resultSet.getInt("familia_numerosa")));
		}

		return listaAlumnos;
	}

	public void updateAlumno(String id, String nombre, String idMunicipio, String familiaNumerosa) throws SQLException {
		String query = "UPDATE alumnos " + " SET nombre = CASE WHEN ? = '' THEN nombre ELSE ? END, "
				+ " id_municipio = CASE WHEN ? = '' THEN id_municipio ELSE ? END, "
				+ " familia_numerosa = CASE WHEN ? ='' THEN familia_numerosa ELSE ? END" + " WHERE id = ?";
		try (Connection connection = DatabaseUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, idMunicipio);
			preparedStatement.setString(4, idMunicipio);
			preparedStatement.setString(5, familiaNumerosa);
			preparedStatement.setString(6, familiaNumerosa);
			preparedStatement.setString(7, id);
			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
			System.out.println("Alumno actualizado con éxito.");
		}
	}

	public void deleteAlumno(int id) throws SQLException {
		String query = "DELETE FROM alumnos WHERE id = ?";
		try (Connection connection = DatabaseUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Alumno eliminado con éxito.");
		}
	}
}
