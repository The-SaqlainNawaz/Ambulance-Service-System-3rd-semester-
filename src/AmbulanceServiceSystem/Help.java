/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AmbulanceServiceSystem;

/**
 *
 * @author zhass
 */
public class Help {
    private Linked_List<String> questions = new Linked_List<>();
    private Linked_List<String> answers = new Linked_List<>();

 Help(){
questions();
answers();
}

    public void questions()
{
questions.insertNode("What is the role of the ambulance service?");
questions.insertNode("What is the ambulance response time?");
questions.insertNode("What are the 9 phases of an ambulance call?");
}
    public void answers()
{
answers.insertNode("As the mobile arm of the health service in Lahore, our main role is to respond to emergency 1122 calls, getting medical help to patients who have serious or life-threatening injuries or illnesses as quickly as possible.");
answers.insertNode("It takes approx 8 minutes for the ambulance to arrive if the call is life threatening or an emergency. Ambulance services often send more than one vehicle to try to meet the 8 minute target. This frustrates ambulance staff and isn't a good use of ambulance services time.");
answers.insertNode("Preparation. An ambulance is a large piece of equipment, stocked with hundreds of pieces of equipment and supplies. ...\n" +
"Dispatch. ...\n" +
"En Route. ...\n" +
"Arrival at Scene. ...\n" +
"Transfer of Patient. ...\n" +
"Transport. ...\n" +
"Delivery. ...\n" +
"En Route to Station.");

}

    public void setQuestions(Linked_List<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(Linked_List<String> answers) {
        this.answers = answers;
    }

    public Linked_List<String> getQuestions() {
        return questions;
    }

    public Linked_List<String> getAnswers() {
        return answers;
    }
    
}
