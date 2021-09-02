/*** BEGIN META {
 "name" : "kubernetes_object_list",
 "comment" : "get list of objects",
 "parameters" : ['NAMESPACE', 'TYPE'],
 "core": "1.609",
 "authors" : [{ name : "livelace" }]
 } END META**/

@Grab("io.fabric8:kubernetes-client:5.7.1")

import io.fabric8.kubernetes.client.DefaultKubernetesClient

def client = new DefaultKubernetesClient()

def result = []

switch (TYPE) {
    case "deployment":
        client.apps().deployments().inNamespace(NAMESPACE).list().items.each { result << it.metadata.name }
        break

    case "pod":
        client.apps().deployments().inNamespace(NAMESPACE).list().items.each { result << it.metadata.name }
        break

    case "service":
        client.services().inNamespace(NAMESPACE).list().items.each { result << it.metadata.name }
        break
}

client.close()

return result ? result : ["---"]


