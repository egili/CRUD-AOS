package project.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DAOs.CRUDHelper;
import project.helpers.Telefone;

public class TelefoneTest {

	private Telefone telefone = null;

	@BeforeEach
	private void instantiate() throws Exception {
		telefone = new Telefone(19, 987654321);
	}

	@Test
	public void ConstructorException() throws Exception {
		assertThrows(Exception.class, () -> telefone = new Telefone(-19, -987654321));
	}

	@Test
	public void dddDoCidadaoTest() {
		assertEquals(19, CRUDHelper.getDDDdoCidadao(telefone.toString()));
	}

	@Test
	public void numeroDoCidadaoTest() {
		assertEquals(987654321, CRUDHelper.getNumerodoCidadao(telefone.toString()));
	}

	@Test
	public void construtorDeCopia() throws Exception {
		Telefone t = new Telefone(telefone);
		assertEquals(telefone.equals(t), true);
	}

	@Test
	public void metodoClone() throws Exception {
		Telefone t = (Telefone) telefone.clone();
		assertEquals(telefone.equals(t), true);
	}
}