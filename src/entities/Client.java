package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

// SimpleDateFormat criado para formatação de datas em Strings
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		private String name;
		private String email;
		private Date birthdate;
		
		public Client() {
		}

		public Client(String name, String email, Date birthdate) {
			super();
			this.name = name;
			this.email = email;
			this.birthdate = birthdate;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}
		
// Retorna informações do cliente em forma de String
		public String toString() {
			return name 
					+ ", e-mail: "
					+ email 
					+ ", Birthdate: " 
					+ sdf.format(birthdate); //Retorna data como foi especificada na instanciação do sdf
		}
}
