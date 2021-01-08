package sma.agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class MyAgent extends Agent{

	@Override
	protected void setup() {
		System.out.println("creation et initialisation de l'agent :"+this.getAID().getName());
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage aclMessage = receive();
				if(aclMessage != null) {
					//si il y'a de message
					
					System.out.println("Reception d'un nouveau message");
					//message content
					System.out.println("Contenu du message : "+aclMessage.getContent());
					//act de commuication
					System.out.println("Act de Communication : "+ACLMessage.getPerformative(aclMessage.getPerformative()));
					//language de communication
					System.out.println("Language : "+aclMessage.getLanguage());	
				}else {
					// y'a pas de message
					block();
				}
				
				
			}
		});
	}

}
