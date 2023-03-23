## Collisto 观星者

| JDK版本 |     Gradle版本      |
|:-----:|:-----------------:|
|  17   |       7.5.1       |
|  19   | 7.6.1+（建议使用8.0.2） |

技术栈：SpringBoot3.1.0-M1 + Gradle8.0.2 + JDK19

| 应用          | 端口   | 用途       |
|-------------|------|----------|
| API-GATEWAY | 8888 | 网关       |
| API-AUTH    | 8899 | 用户访问鉴权   |
| API-GPT     | 8988 | CHAT-GPT |
### 快速部署：
1. 导入项目后，点击 File -> Project Structure 
   1. Project中调整SDK为JDK17/JDK19，并调整Language Level为对应版本17/19
   2. Module中，点击+号，import Module，依次选择每个模块，Import -> Gralde -> Next -> apply
2. 点击Setting，搜索Gradle
   1. 将Use Gradle Form修改为Specified location,并修改gradle安装路径
3. 在Nacos配置管理中，创建对应的配置文件（注意group和data-id）
4. 修改每个应用中的Nacos配置信息
5. 依次启动每个应用
