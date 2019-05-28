# 勤怠管理システム
今回はいろいろ試してみる

- xhtml - backing beanは1対1対応
- RequestScopedを使う
- SessionScopedは保持するときのみ
- CDIでは`javax.enterprise.context.SessionScoped`を使う
- ManagedBeanでは`javax.faces.bean.SessionScoped`を使う

```java
@ManagedProperty(value="#{javaclass}")
private Javaclass javaclass = null;
```

もしくは

```java
@Inject
private Javaclass javaclass = null;

@Named
@javax.enterprise.context.RequestScoped
public class Javaclass
```

セッション終了
```java
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
```
