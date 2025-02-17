# 1. Tomcat 9 の公式イメージを使用
FROM tomcat:9.0

# 2. WARファイルをTomcatのwebappsフォルダにコピー
COPY beerLists.war /usr/local/tomcat/webapps/ROOT.war

# 3. Tomcatを起動
CMD ["catalina.sh", "run"]
