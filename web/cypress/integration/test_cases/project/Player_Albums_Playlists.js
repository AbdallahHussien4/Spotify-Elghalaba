// Auto Complite 
/// <reference types="Cypress" />  


describe('Test Music Player & Albums & Playlists Sprint #4',()=>{

    beforeEach(()=>{    
        
        cy.viewport("macbook-15");          //To Change the default view(Tablet) to desktop
        cy.visit('https://spotify-elghalaba.me');  //To Open the site
        cy.get('[href="/login"]').click();  //Click on login button
        cy.get('.v-text-field__slot [type="text"]').type("user@free.com");  //type the username
        cy.get('.v-text-field__slot [type="password"').type("password"); //type the password
        cy.get('#loginBtn').click();  //click login
        cy.wait(2000);
        
    });       

    it('Test Liked Songs Playlist URL',()=>{

        cy.get('[href="/home/library/tracks"]').click();
        cy.url().should('equal','https://spotify-elghalaba.me/home/library/tracks');

    })

    it('Test the title of the playlist',()=>{

        cy.get('[href="/home/library/tracks"]').click();
        cy.title().should('contains','Spotify');

    })

    it('Test Play Button in Playlist',()=>{
        cy.get('[href="/home/library/tracks"]').click();
        cy.wait(4000);
        cy.get('.px-10').contains('Play');
        cy.get('.px-10').click();
        cy.get('.px-10').contains('Pause');
        cy.get('.px-10').click();
        cy.get('.px-10').contains('Play');
    })


    it('Test The heart button in playlist',()=>{

        cy.get('[href="/home/library/playlists"]').click();
        cy.get('.mx-auto').last().click();
        cy.wait(3000);
        cy.get('.mdi-heart-outline[type="button"]').should('be.visible');
        cy.get('.mdi-heart[type="button"]').should('not.be.visible');
        cy.get('.mdi-heart-outline[type="button"]').first().click();
        cy.get('[role="alert"]').should('contain','Saved to Your Library');
        cy.get('.mdi-heart-outline[type="button"]').first().should('not.be.visible');
        cy.get('.mdi-heart[type="button"]').should('be.visible');
        cy.get('.mdi-heart[type="button"]').click();
        cy.get('[role="alert"]').should('contain','Removed from Your Library');
    })

    it('Test The Logo',()=>{
        cy.get('[href="/home/library/tracks"]').click();
        cy.get('[style="width: 1280px;"]').click();
        cy.url().should('equal','https://spotify-elghalaba.me/home');

    })
    


    it('Test the Play Button in Playlist',()=>{

        cy.get('[href="/home/library/tracks"]').click();
        cy.wait(1000);
        cy.get('.mt-1').click();
        cy.get('.mt-2').should('contain','Play');
        cy.get('.mdi-play-circle-outline').first().click();
        cy.get('.mt-2').should('contain','Pause');


    })
    

    it('Test the dropdownlist in playlist',()=>{

        cy.get('[href="/home/library/playlists"]').click();
        cy.get('.mx-auto').first().click();
        cy.wait(3000);
        cy.get('Label').first().click({force: true});
        cy.get('.mdi-dots-horizontal').first().click({force:true});
        cy.get('#app').contains("Click Me");   //should be a dropdownlist    

    })

    it('Test Queue Page URL',()=>{

        cy.get('.mdi-playlist-play').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/queue');
    })

    it('Test Queue Page Components',()=>{

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('label').then((x)=>{

            cy.get('.mdi-playlist-play').click();   
            cy.get('.mdi-playlist-play').should('have.class','green--text');  
            cy.get('.v-content__wrap').should('contain','Now Playing');
            cy.get('.v-content__wrap').should('contain','Play Queue');
            cy.get('.v-content__wrap').should('contain','Next Up');
            cy.get('label').then((y)=>{
                expect(x.length).to.equal(y.length);
            });
            
        });
        cy.get('.v-content__wrap').then((x)=>{
            cy.get('#song-name').then((y)=>{
            expect(x).to.contain(y.text());
            });
        });
    })

    it('Test the back from the Queue Page ',()=>{

        cy.get('.mdi-playlist-play').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/queue');
        cy.get('.mdi-playlist-play').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home');

    })

    it('Test the back button in the Queue Page',()=>{

        cy.get('.mdi-playlist-play').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/queue');
        cy.get('.mdi-chevron-left').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home');


    })

    it('Test Albums URL',()=>{

        cy.get('[href="/home/library/playlists"]').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/library/playlists');
        cy.get('[value="Albums"]').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/library/albums');
        

    })

   it('Test Playlists URL',()=>{

        cy.get('[href="/home/library/playlists"]').click(); 
        cy.url().should('equal','https://spotify-elghalaba.me/home/library/playlists');
        cy.wait(500);
        cy.get('.mx-auto').last().click();
        cy.url().should('contain','https://spotify-elghalaba.me/playlist');

    })


    it('Test the volume bar',()=>{

        cy.get('#volume-bar').click();
        cy.get('#volume-bar').click({ position: 'topRight' })
        cy.get('#volume-bar').should('have.attr','aria-valuenow', '99'); 
    })

    it('Test the Play Button in the Music Player',()=>{
       
        cy.wait(2000);
        cy.get('.mdi-play-circle-outline').click();
        cy.wait(1000);
        cy.get('.mdi-pause-circle-outline').click(); 
        
    })

    it('Test the seek bar',()=>{
        cy.wait(2000);
        cy.get('.mdi-play-circle-outline').click();
        cy.wait(5000);
        cy.get('.mdi-pause-circle-outline').click(); 
        cy.get('[role="progressbar"]').first().click();
        cy.wait(3000);
        cy.get('[role="progressbar"]').first().should('have.attr','aria-valuenow').then((attr)=>{
            expect(Number(attr)).to.be.above(49.0).and.to.be.below(51.0);
        }); 
    })

    it('Test the Heart Button in the Music Player',()=>{

        cy.get('#heart-outline').should('be.visible');
        cy.get('#heart-outline').click();
        cy.get('#snack-bar').should('contain','Added to your Liked Songs')
        cy.get('#heart').should('be.visible');
        cy.get('#heart').click();
        cy.get('#snack-bar').should('contain','Removed from your Liked Songs')
        cy.get('#heart-outline').should('be.visible');
        cy.get('#heart-outline').click();
        cy.get('#inner-user-btn').click();
        cy.get('#logout-item').click();
        cy.get('[href="/login"]').click();  //Click on login button
        cy.get('.v-text-field__slot [type="text"]').type("user@free.com");  //type the username
        cy.get('.v-text-field__slot [type="password"').type("password"); //type the password
        cy.get('#loginBtn').click();  //click login
        cy.wait(4000);
        cy.get('#heart').should('be.visible');
        cy.get('#heart-outline').should('not.be.visible');

    })
    
   it('Test the Song name & image in the Music Player',()=>{

        cy.get('.elevation-0').find('a').first().click({force: true});
        cy.url().should('not.contain','undefined').and('contain','album');
        cy.go('back');
        cy.get("#song-name").click();
        cy.url().should('not.contain','undefined').and('contain','album');
    })

    it('Test if the song name and image has the same url ',()=>{

        cy.get('.elevation-0').find('a').first().click({force: true});
        cy.url().then((x)=>{

            cy.go('back');
            cy.get("#song-name").click();
            cy.url().then((y)=>{
        
            expect(y).to.equal(x);
            });
        });
    })

    it('Test the Artists in the Music Player',()=>{
        cy.get('.elevation-0').find('a').last().click({force: true});
        cy.url().should('contain','artist');
    })

    it('Test the song body in the playlist' ,()=>{

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(10000);

        cy.get('.mt-2').should('contain','Play');
        cy.get('.subtitle').first().should('have.css','color').and('equal', 'rgb(255, 255, 255)');
        cy.get('label').first().should('have.css','color').and('equal', 'rgb(128, 128, 128)');
        cy.get('.mdi-volume-high').should('not.be.visible');

        cy.get('#songBar').dblclick();

        cy.get('.mt-2').should('contain','Pause');
        cy.get('.subtitle').first().should('have.css','color').and('equal', 'rgb(30, 215, 96)');
        cy.get('label').first().should('have.css','color').and('equal', 'rgb(30, 215, 96)');

        cy.get('.mdi-music-note-outline').should('be.visible');
        cy.get('.mdi-play').should('not.be.visible');
        cy.get('.subtitle').last().click();
        cy.get('.mdi-play').should('be.visible');

        cy.get('.mdi-volume-high').should('be.visible');
        cy.get('.mdi-pause').should('not.be.visible');
        cy.get('.subtitle').first().click();
        cy.get('.mdi-volume-high').should('not.be.visible');
        cy.get('.mdi-pause').should('be.visible');

        cy.get('#songBar').dblclick();

        cy.get('.mt-2').should('contain','Play');
        cy.get('.subtitle').first().should('have.css','color').and('equal', 'rgb(255, 255, 255)');
        cy.get('label').first().should('have.css','color').and('equal', 'rgb(128, 128, 128)');
        cy.get('.mdi-volume-high').should('not.be.visible');

    })
    it('Test the song number in the playlist' ,()=>{
        cy.get('[href="/home/library/playlists"]').click();
        cy.get('.mx-auto').first().click();
        cy.wait(3000);
        cy.get('label').then((x)=>{

            cy.get('#songNum').then((y)=>{
                expect(' '+x.length+' Songs ').to.equal(y.text());
            });
            
        });

    })

    it('Test the Mute button in the music player' ,()=>{
        cy.get('.mdi-volume-medium').should('be.visible');
        cy.get('.mdi-volume-mute').should('not.be.visible');
        cy.get('.mdi-volume-medium').click();
        cy.get('.mdi-volume-medium').should('not.be.visible');
        cy.get('.mdi-volume-mute').should('be.visible');
        cy.get('.mdi-volume-mute').click();
        cy.get('.mdi-volume-medium').should('be.visible');
        cy.get('.mdi-volume-mute').should('not.be.visible');

    })

    it('Test Shuffle button in music player' ,()=>{

        cy.get('#shuffle-btn').should('have.class','grey--text');
        cy.get('#shuffle-btn').click();
        cy.get('#shuffle-btn').should('have.class','green--text');
        
    })

    it('Test repeat button in music player' ,()=>{

        cy.get('#repeat-btn').should('have.class','grey--text');
        cy.get('#repeat-btn').click();
        cy.get('#repeat-btn').should('have.class','green--text');
        
    })

    it('Test the connection between playlists and music player' ,()=>{

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(2000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(2000);
    
        cy.get('.subtitle').first().dblclick({force: true});
        cy.get('.subtitle').first().then((x)=>{
            cy.get('#song-name').then((y)=>{
                expect(x.text()).to.equal(y.text());
            });
        });
        cy.get('.subtitle').last().dblclick();
        cy.get('.subtitle').last().then((x)=>{
            cy.get('#song-name').then((y)=>{
                expect(x.text()).to.equal(y.text());
            });
        });
    })

    it('Test Like playlist logic',()=>{
        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('a');
        cy.wait(3000);
        cy.get('[xs="12"]').eq(12).click();
        cy.wait(10000);
        cy.get('.mdi-heart-outline').first().click();
        cy.wait(5000);

        cy.get('.headline').then((playlist)=>{
        cy.get('[href="/home/library/playlists"]').click();
        cy.wait(1000);
        cy.get('#nameID').then((x)=>{
        expect(' '+x.text()+' ').to.equal(playlist.text());
        })
        });

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('a');
        cy.wait(3000);
        cy.get('[xs="12"]').eq(12).click();
        cy.wait(10000);
        cy.get('.mdi-heart').last().click();
        cy.wait(5000);

        cy.get('.headline').then((playlist)=>{
        cy.get('[href="/home/library/playlists"]').click();
        cy.wait(1000);
        cy.get('#nameID').then((x)=>{
            expect(' '+x.text()+' ').not.to.equal(playlist.text());
            })
        });

    })

    it('Test Like Album logic',()=>{
        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(2000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('.mdi-heart-outline').first().click();
        cy.wait(5000);

        cy.get('.headline').then((playlist)=>{
        cy.get('[href="/home/library/playlists"]').click();
        cy.get('[href="/home/library/albums"]').click();
        cy.wait(1000);
        cy.get('#nameID').then((x)=>{
        expect(' '+x.text()+' ').to.equal(playlist.text());
        })
        });

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(2000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('.mdi-heart').last().click();
        cy.wait(5000);

        cy.get('.headline').then((playlist)=>{
        cy.get('[href="/home/library/playlists"]').click();
        cy.get('[href="/home/library/albums"]').click();
        cy.wait(1000);
        cy.get('.v-content__wrap').should('not.contain',playlist.text());

    });
})

    it('Test Like Song logic',()=>{
        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('#songName').then((x)=>{
        cy.get('#heart-outline').click();
        cy.get('[href="/home/library/tracks"]').click();
        cy.get('.my-1').should('contain',x.text());
        cy.go("back");
        cy.get('#heart').click();
        cy.get('[href="/home/library/tracks"]').click();
        cy.get('.my-1').should('not.contain',x.text());
        });
    })

    it('Test Repeat button logic',()=>{
        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('#songName').then((x)=>{
        cy.get('[role="progressbar"]').first().click({position: 'topRight' });
        cy.wait(2000);    
        cy.get('#song-name').should('not.contain',x.text());
        });
        cy.get("#repeat-btn").click();
        cy.get('.subtitle').eq(1).then((x)=>{
            cy.get('[role="progressbar"]').first().click({position: 'topRight' });
            cy.wait(2000);    
            cy.get('#song-name').should('contain',x.text());
        });
    })

    it('Test Back&Forward Buttons',()=>{
        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('.subtitle').eq(1).then((x)=>{

            cy.get('#song-name').should('not.contain',x.text());
        });
        cy.get('#skip-next-btn').click();
        cy.get('.subtitle').eq(1).then((x)=>{

            cy.get('#song-name').should('contain',x.text());
        });
        cy.get('#skip-previous-btn').click();
        cy.get('.subtitle').eq(0).then((x)=>{

            cy.get('#song-name').should('contain',x.text());
        });
    })

    it('Test Shuffle button doesnot change the playlist',()=>{

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('.subtitle').last().then((x)=>{
            cy.get('#shuffle-btn').click();
            cy.wait(1000);
            cy.get('.subtitle').last().should('contain',x.text());
        });
    })

    it('Test UnShuffle button return the queue order back',()=>{

        cy.get('[href="/home/search"]').click();
        cy.get('#search-bar').type('ja');
        cy.wait(3000);
        cy.get('.seeAll').first().click();
        cy.wait(1000);
        cy.get('[xs="12"]').eq(6).click();
        cy.wait(6000);
        cy.get('#songName').dblclick();
        cy.wait(5000);
        cy.get('#queue-btn').click();
        cy.get('.subtitle').eq(1).then((x)=>{
            cy.get('#shuffle-btn').click();
            cy.wait(1000);
            cy.get('#shuffle-btn').click();
            cy.wait(1000);
            cy.get('.subtitle').eq(1).should('contain',x.text());
        });
    })

    it('Test Forward&back buttons with empty queue',()=>{

        cy.wait(2000);
        cy.get('#song-name').should('not.contain','Faded')
        cy.get('#skip-next-btn').click();
        cy.wait(1000);
        cy.get('#song-name').should('not.contain','Faded')

        cy.get('#skip-previous-btn').click();
        cy.wait(1000);
        cy.get('#song-name').should('not.contain','Faded')

    })
})


