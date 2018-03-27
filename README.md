# TagExtractor

Java Library for extracting tags from a Web page or plain text, using Text Rank algorithm. This is only available for English and Korean.

## Getting Started

Construct TagExtractor Instance and do works with extractTagFromWebPage method or extractTagFromText method.

Simple text code is written in App.java

```
    TagExtractor te = new TagExtractor();
		List<String> tags = te.extractTagFromWebPage("https://redis.io/topics/quickstart"); // extract tags from web page

		for(String tag : tags ){
			System.out.println(tag); // print extracted tags
		}
```


### Prerequisites

You need jars in libs folder as depedencies. And also need resoure file in res folder.

### Installing

locate 'res' folder at project root path to read resource files under it.

```

## Demo

Extracting tags from "https://en.wikipedia.org/wiki/Spring_Framework"

```
>>console
log4j:WARN No appenders could be found for logger (ml.com.tagExtractor.textRank.korean.KoreanSentence).
log4j:WARN Please initialize the log4j system properly.
container
objects
framework
spring framework
spring
```

## Built With

* [jsoup](https://jsoup.org/) - to extract plain text from web page
* [[https://github.com/ceteri/textrank] - reference for implementing text rank algorithm
* [TwitterKoreanText](https://github.com/twitter/twitter-korean-text) - to tokenize korean


## License

As-is

