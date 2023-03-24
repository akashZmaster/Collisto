## Collisto 观星者

### ~~♠当前项目版本：v0.1.2~~

|  项目版本  |        更新说明        |    更新时间    | 项目进度 | 
|:------:|:------------------:|:----------:|:----:|
| v0.1.0 |       项目初始化        | 2023-03-23 | 100% |
| v0.1.1 |   接入Nacos Config   | 2023-03-24 | 100% |
| v0.1.2 |   主子模块Gradle配置优化   | 2023-03-24 | 100% |
| v0.1.3 | GPT模块优化，追加支持API新功能 |            |  0%  |
   
### ♠项目技术栈

| JDK版本 |     Gradle版本      |    SpringBoot版本    |
|:-----:|:-----------------:|:------------------:|
|  17   |       7.5.1       | SpringBoot3.1.0-M1 |
|  19   | 7.6.1+（建议使用8.0.2） | SpringBoot3.1.0-M1 |

### ♠项目结构

| 应用          | 端口   | 用途       |
|-------------|------|----------|
| API-GATEWAY | 8888 | 网关       |
| API-AUTH    | 8899 | 用户访问鉴权   |
| API-GPT     | 8988 | CHAT-GPT |

### ♠快速部署：
>1. 导入项目后，点击 File -> Project Structure 
>   1. Project中调整SDK为JDK17/JDK19，并调整Language Level为对应版本17/19
>   2. ~~Module中，点击+号，import Module，依次选择每个模块，Import -> Gralde -> Next -> apply~~
>2. 点击Setting，搜索Gradle
>   1. 将Use Gradle Form修改为Specified location,并修改gradle安装路径
>3. 在Nacos配置管理中，创建对应的配置文件（注意group和data-id）
>4. 修改每个应用中的Nacos配置信息
>5. 启动应用