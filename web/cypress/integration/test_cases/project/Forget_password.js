// / <reference types="Cypress" />
describe('forget password ', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
    });
    {
        it('Forget password', () => {
            cy.get('#forgotPasswordPrompt').click()
            cy.get("#emailField").type("mohamed.sayed8899@hotmail.com")
            cy.get("#sendBtn").click();
            cy.wait(2000);// wait for response
            cy.get("p").eq(1).should('contain', 'A message has been sent to you by email ');
            //send email but link in email doesn't work //phase 2
        });
    }



});