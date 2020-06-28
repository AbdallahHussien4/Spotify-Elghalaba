// / <reference types="Cypress" />
describe(' facebook login', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
    });
    {
        it('login with facebook', () => {
            cy.get('.v-btn__content').contains(" Log in with Facebook ").click();
            cy.wait(4000);
            cy.url().should('contain', "facebook");
        });
    }


});