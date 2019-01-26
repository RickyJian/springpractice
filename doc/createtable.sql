USE [springpractice]
GO

/****** Object:  Table [dbo].[user_account]    Script Date: 2019/1/26 ¤U¤È 09:26:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_account](
	[user_name] [varchar](25) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_user_account] PRIMARY KEY CLUSTERED 
(
	[user_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


