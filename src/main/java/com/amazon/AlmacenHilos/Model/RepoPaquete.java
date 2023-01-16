package com.amazon.AlmacenHilos.Model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RepoClient")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoPaquete implements Serializable{
		
		private static final long serialVersionUID = 1L;

		private static RepoPaquete _instance;
		
		HashMap<Integer, Paquete> paquetesList;
		
		private RepoPaquete() {
			paquetesList= new HashMap <Integer, Paquete>();
		}
		
		public static RepoPaquete getInstance() {
			if (_instance==null) {
				_instance=new RepoPaquete();
			}
			return _instance;
		}
		
		

		public boolean addPaquete(Paquete c) {
			Paquete aux= (Paquete) c;
			boolean added=false;
			if(!this.paquetesList.containsKey(aux.getId())) {
				this.paquetesList.put(aux.getId(), aux);
				added=true;
			}
			return added;
		}
		
		
		public Paquete removePaquete(Integer ID) {
			Paquete aux = new Paquete();
			if(this.paquetesList.containsKey(ID)) {
				aux=this.paquetesList.get(ID);
				this.paquetesList.remove(ID);	
				return aux;
			}
			return null;
			
		}
		public HashMap<Integer, Paquete> getPaquetesList(){
			return paquetesList;
		}
		public boolean Contains(Integer id) {
			return paquetesList.containsKey(id);
		}
		public boolean isEmpty() {
			return paquetesList.isEmpty();
		}

		public void saveFile(String url) {
			JAXBContext contexto; 
			try {
				contexto = JAXBContext.newInstance(RepoPaquete.class);
				Marshaller m = ((JAXBContext) contexto).createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
				m.marshal(_instance, new File(url));
			
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		public void loadFile(String url) {
			JAXBContext contexto;

			try {
				contexto = JAXBContext.newInstance(RepoPaquete.class);
				Unmarshaller um = contexto.createUnmarshaller();
				RepoPaquete newRepoProduct = (RepoPaquete) um.unmarshal(new File(url));
				paquetesList = newRepoProduct.paquetesList;
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	
}