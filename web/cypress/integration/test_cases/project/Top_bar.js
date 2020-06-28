// / <reference types="Cypress" />
describe(' Tob bar', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type('12345678');
        cy.get('.v-btn__content').contains('Log In').click();
    });
    {
        it('go back and go forward in home', () => {
            cy.wait(3000);
            cy.get(".v-btn__content").eq(0).should('be.disabled');//back arrow
            cy.get(".v-btn__content").eq(1).should('be.disabled');//right arrow
        });
    }


});