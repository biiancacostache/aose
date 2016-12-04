package com.btesila.aose.jade.labs;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by Bii on 12/4/2016.
 */
public class Pong extends Agent {
    protected void setup()
    {
        addBehaviour(new CyclicBehaviour(this)
        {
            public void action()
            {
                ACLMessage msg = receive();
                if (msg!=null) {
                    System.out.println( " - " +
                            myAgent.getLocalName() + " received: " +
                            msg.getContent() );

                    ACLMessage reply = msg.createReply();
                    reply.setPerformative( ACLMessage.INFORM );
                    reply.setContent(" Pong" );
                    send(reply);
                }
                block();
            }
        });
    }
}
