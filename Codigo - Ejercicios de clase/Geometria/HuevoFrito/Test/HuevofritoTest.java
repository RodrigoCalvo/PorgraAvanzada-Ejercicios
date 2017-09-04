import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HuevofritoTest {
		Huevofrito h;
		
		@Before
		public void SetUp() {
			
			h = new Huevofrito();
		}
		
		
		@Test
		public void queIniciaEnCero()
		{
			
			Assert.assertEquals(0, h.mostrar());
		}
		
		@Test
		public void queIncrementaUno()
		{
			
			h.contar();
			Assert.assertEquals(1, h.mostrar());
		}
		public void queIncrementaDos()
		{
			
			h.contar();
			h.contar();
			Assert.assertEquals(2, h.mostrar());
		}
		public void queCuentaHastaUnMillon()
		{
			
			for(int i=0; i<1_000_000; i++)
			{
				h.contar();
			}
			Assert.assertEquals(1_000_000, h.mostrar());
		}
}


