import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http'; // ativando o HttpCliente para fazer requisicoes nativas do Angular (GET, POST, DELETE)

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes), provideClientHydration(),
    provideHttpClient() // ativando o HttpCliente para fazer requisicoes nativas do Angular (GET, POST, DELETE)
  ]
};
