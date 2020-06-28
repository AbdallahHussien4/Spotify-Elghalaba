// / <reference types="Cypress" />
{
  describe(' Normal login ', () => {
    beforeEach(() => { // runs once before all tests in the block
      cy.visit('https://spotify-elghalaba.me/');
      cy.get('.v-btn__content').eq(2).click();
    });
    {
      it('full!', () => {
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type('12345678');
        cy.get('.v-btn__content').contains('Log In').click();
        cy.url().should('contain', 'home');
      });
    }

    {
      it('missed username!', () => {
        cy.get('#passwordField').type('12345678');
        cy.get('.v-btn__content').contains('Log In').click();
        cy.url().should('contain', 'login');
      });
    }
    {
      it('missed password!', () => {
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('.v-btn__content').contains('Log In').click();
        cy.url().should('contain', 'login');
      });
    }
  });
}
