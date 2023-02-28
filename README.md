# Open Data Connector - Simulación Java Client

Open Data Connector - Simulación.<br/><img src='https://github.com/APIHub-CdC/imagenes-cdc/blob/master/circulo_de_credito-apihub.png' height='37' width='160'/></p><br/>

## Requerimientos

 1. Java >= 8 
 2. Maven >= 3 

## Instalación

**Prerrequisito**: obtener token de acceso y configuración de las credenciales de acceso. Consulte el manual **[aquí](https://github.com/APIHub-CdC/maven-github-packages)**.

**Opción 1**: En caso que la configuración se integró en el archivo **settingsAPIHUB.xml** (ubicado en la raíz del proyecto), instale las dependencias con siguiente comando:

```shell
mvn --settings settingsAPIHUB.xml clean install -Dmaven.test.skip=true
```

**Opción 2**: Si se integró la configuración en el **settings.xml** del **.m2**, instale las dependencias con siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Modificar Datos de la petición:
En el archivo ***TelcosApiTest.java***, que se encuentra en ***src/test/java/mx/com/cdc/odc/client/test***. Se deberá modificar los datos de la petición y los datos de consumo:

> **NOTA:** Los datos de la siguiente petición son solo representativos.

```java
package mx.com.cdc.odc.client.test;
...
public class TelcosApiTest {

	private static final Logger log = LoggerFactory.getLogger(TelcosApiTest.class);
	
	private String url                 = "";
	private String xApiKey             = "";
	private String username            = "";
	private String password            = "";
	
    private ApiClient apiClient;
	
	private final TelcosApi api = new TelcosApi();
    
	@Before()
	public void setUp() {
	    
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
	  
	    OkHttpClient okHttpClient = new OkHttpClient()
	    .newBuilder()
	    .readTimeout(30, TimeUnit.SECONDS)
	    .build();
	  
	    this.apiClient.setHttpClient(okHttpClient);
	} 
    
    @Test
    public void getTelcosTest() throws Exception {
    	
        String subscriptionId = "your-subscription-id";
        
        TelcosRequestPayload body = new TelcosRequestPayload();
        body.setReadBilling(true);
        body.setReadCreditPayments(true);
        body.setReadPaymentHistory(true);
        body.setReadPlanDetails(true);
        body.setReadSummary(true);
        body.setRequestCode("");
        body.setStartDate(LocalDate.parse(""));
        
        try {
			AggregationServiceResponsePayload response = api.getTelcos(
					xApiKey, 
					subscriptionId, 
					username, 
					password,
					body);
			
			log.info(response.toString());
			
		} catch (ApiException exception) {
			
			log.error(exception.getResponseBody());
		}
    }
    
}
      
```
### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:
```shell
mvn test -Dmaven.install.skip=true
```
---
[CONDICIONES DE USO, REPRODUCCIÓN Y DISTRIBUCIÓN](https://github.com/APIHub-CdC/licencias-cdc)

[1]: https://getcomposer.org/doc/00-intro.md#installation-linux-unix-macos
